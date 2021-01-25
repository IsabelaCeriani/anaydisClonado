package anaydis.compression;

import anaydis.bit.Bits;
import anaydis.bit.BitsOutputStream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Bit extends Bits {


    private int value;
    private int size;


    public Bit add(boolean bit){
        value = value << 1; //shifteo a la izq para crearme el espacio donde meter el bit
        if(bit) value  = value | 1; // si es true "prendo" el primer bit (bit mas a la derecha) 1 = 00000001
        size++; //incremento el size para tener memoria de cuantas veces agregue un bit y diferenciar de los originales
        return this;
    }

    public boolean bitAt(String str, int nth){
        final int pos = nth/8;
        return pos < str.length() && (str.charAt(pos)>>(nth%8) & 1) != 0 ;

    }

    public void writeInto(OutputStream outputStream) throws IOException {
        outputStream.write(size);
        final BitsOutputStream bos = new BitsOutputStream();
        bos.write(this);
        outputStream.write(bos.toByteArray());

    }
}
