package Week2.Point2DAndPoint3D;

import java.util.*;

public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D(){
    }

    public Point3D(float x, float y, float z){
        super(x,y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public float[] getXYZ(){
        float[] array = {super.getX(),super.getY(),z};
        return array;
    }

    public void setXYZ(float x, float y, float z){
        super.setXY(x,y);
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point 3D: "+ Arrays.toString(getXYZ())+" ,which is a subclass of: "+super.toString();
    }
}
