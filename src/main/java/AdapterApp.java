/**
 * Created by Vladimir on 11.09.2016.
 */
public class AdapterApp {
    public static void main(String[] args){
        //1-st approach (inheritance)
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawLine();
        g1.drawSquare();

        //2-d approach (Composition)
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2(new RasterGraphics());
        g2.drawLine();
        g2.drawSquare();


    }
}

interface VectorGraphicsInterface{
    void drawLine();
    void drawSquare();
}
class RasterGraphics{
    void drawRasterLine(){
        System.out.println("------------");
    }
    void drawRasterSquare(){
        System.out.println("[]");
    }
}
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{
    public void drawLine() {
        drawRasterLine();
    }
    public void drawSquare() {
        drawRasterSquare();
    }
}

class VectorAdapterFromRaster2 implements VectorGraphicsInterface{
    RasterGraphics raster = null;//new RasterGraphics();

    public VectorAdapterFromRaster2(RasterGraphics raster) {
        this.raster = raster;
    }
    public void drawLine() {
        raster.drawRasterLine();
    }
    public void drawSquare() {
        raster.drawRasterSquare();
    }
}
