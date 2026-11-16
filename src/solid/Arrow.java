package solid;

import transforms.Point3D;

import java.util.ArrayList;

public class Arrow extends Solid{

    public Arrow(){
        //todo: naplnit vb bude model space od -1 do 1
        //zatím nemáme celou pipeline proto to musíme zadat souřadnicích okna
        vb.add(new Point3D(200, 200, 0)); //v0
        vb.add(new Point3D(300, 200, 0)); //v1
        vb.add(new Point3D(300, 250, 0)); //v2
        vb.add(new Point3D(350, 200, 0)); //v3
        vb.add(new Point3D(300, 150, 0)); //v4

        //todo: naplnit ib
//        //v0-v1
//        ib.add(0);
//        ib.add(1);
//
//        //v2-v3
//        ib.add(2);
//        ib.add(3);
//
//        //v2-v4
//        ib.add(2);
//        ib.add(4);
//
//        //v4-v3
//        ib.add(4);
//        ib.add(3);

        //pomocí vyfikundace v javě
        addIndices(0,1,2,3,2,4,4,3);
    }
}
