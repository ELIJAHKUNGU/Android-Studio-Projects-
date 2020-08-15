package comt.king.mypaints;

import java.nio.file.Path;

public class fingerPath {
    public int color;
    public boolean emboss;
    public boolean blur;
    public int strokeWidtgh;
    public Path path;


//    public fingerPath(int color, boolean emboss, boolean blur, int strokeWidth, Path Path) {
//        this.color = color;
//        this.emboss = emboss;
//        this.blur = blur;
//        this.strokeWidtgh = strokeWidtgh;
//        this.path = path;
//    }

    public fingerPath(int currentcolor, boolean emboss, boolean blur, int strokeWidth, Path mPath) {
        this.color = color;
        this.emboss = emboss;
        this.blur = blur;
        this.strokeWidtgh = strokeWidtgh;
        this.path = path;
    }
}
