package util;


/**
 * Created by aristark on 4/1/16.
 * Simple generator implementation
 */
public class CountingGenerator {
    public static class
    Boolean implements Generator<java.lang.Boolean>{
        private boolean value = false;

        @Override
        public java.lang.Boolean next() {
            value = !value;
            return value;
        }
    }

    public static class
    Byte implements Generator<java.lang.Byte>{

        private byte value = 0;
        @Override
        public java.lang.Byte next() {
            return value++;
        }
    }

    static char[] chars = ("abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    public static class
    Character implements Generator<java.lang.Character>{
        private int index = -1;

        @Override
        public java.lang.Character next() {
            index = (index+1) % chars.length;
            return chars[index];
        }
    }

    public static class
    String implements Generator<java.lang.String>{
        private int length = 7;

        Generator<java.lang.Character> cg = new Character();
        public String(){}

        public String(int length){
            this.length = length;
        }


        @Override
        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i=0;i<length;i++){
                buf[i] = cg.next();
            }
            return new java.lang.String(buf);
        }
    }

    public static class
    Short implements Generator<java.lang.Short>{
        private short value = 0;

        @Override
        public java.lang.Short next() {
            return value++;
        }
    }

    public static class
    Integer implements Generator<java.lang.Integer>{
        private int value = 0;

        @Override
        public java.lang.Integer next() {
            return value++;
        }
    }

    public static class
    Float implements Generator<java.lang.Float>{
        private float value = 0;

        @Override
        public java.lang.Float next() {
            value += 1.0;
            return value;
        }
    }

    public static class
    Double implements Generator<java.lang.Double>{
        private double value  = 0.0;

        @Override
        public java.lang.Double next() {
            value += 1.0;
            return value;
        }
    }

}
