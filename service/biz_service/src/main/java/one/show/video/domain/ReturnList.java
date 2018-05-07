package one.show.video.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReturnList<V> implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = -8374936164492816192L;
    public List<V> objects = new ArrayList<V>();
    public Integer count = 0;


    public List<V> getObjects() {
        return objects;
    }

    public void setObjects(List<V> objects) {
        this.objects = objects;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
