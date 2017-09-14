package sunny.arraypool.core;

import java.util.ArrayList;

/**
 * Created by lzx on 17/9/7.
 */
public class WeakDeamonRunner<T> implements Runnable{

    ArrayList<LinkList> linkLists = new ArrayList<>();
    private int weakTimeout;
    private int releaseTimeout;

    private int loopInterval = 3000;

    public WeakDeamonRunner(int weakTimeout, int releaseTimeout, int loopInterval)
    {
        this.weakTimeout = weakTimeout;
        this.releaseTimeout = releaseTimeout;

        this.loopInterval = loopInterval;
    }
    
    public void addLinkList(LinkList<T> list)
    {
        linkLists.add(list);
    }
    
    @Override
    public void run() {
        while(true) {
            for (LinkList<T> list : linkLists) {
                try {
                    run(list);
                }catch(Throwable t)
                {
                    t.printStackTrace();
                }
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void run(LinkList<T> list) {
        Element<T> ele = list.tail();
        if(ele==null)
            return;

        int duration = (int)(System.currentTimeMillis() - ele.lastTime);
        if(duration<weakTimeout)
            return;
        
        if(duration>releaseTimeout) {
            ele.release();
            
            while(ele.prev!=null) {
                
                duration = (int) (System.currentTimeMillis() - ele.prev.lastTime);
                if (duration > releaseTimeout) {
                    ele.release();
                    ele = ele.prev;
                }
            }
            
            list.trimFrom(ele);

            ele = list.tail();
            if(ele==null)
                return;

            duration = (int)(System.currentTimeMillis() - ele.lastTime);
            if(duration<weakTimeout)
                return;
        }

        ele.weak();
        while(ele.prev!=null) {

            duration = (int) (System.currentTimeMillis() - ele.prev.lastTime);
            if (duration > weakTimeout) {
                ele.weak();
                ele = ele.prev;
            }
        }
    }

    public void start() {

        new Thread(this, "WeakDeamon").start();
    }
}
