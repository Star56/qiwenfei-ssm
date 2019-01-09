package com.qiwenfei.note.jca;

import java.security.MessageDigest;

/**
 * 2019/1/7
 * sunshine
 */
    public class XYZMessageDigest extends MessageDigest{
        private int hash;
        private int store;
        private int count;

        public XYZMessageDigest(){
            super("XYZ");
            engineReset();
        }

        /**
         * 算法执行过程，每次执行{@link MessageDigest#update(byte)}时，都会调用这个方法，
         * 也就是使用这个算法对在已经计算的数据的基础上再次计算，计算出最新的结果
         */
        @Override
        protected void engineUpdate(byte b) {
            switch (count) {
                case 0:
                    store = (b << 24) & 0xff000000;
                    break;
                case 1:
                    store |= (b << 16) & 0x00ff0000;
                    break;
                case 2:
                    store |= (b << 8) & 0x0000ff00;
                    break;
                case 3:
                    store |= (b << 0) & 0x000000ff;
                    break;
            }
            count++;
            if(count==4){
                hash = hash ^ store;
                count = 0;
                store = 0;
            }
        }

        @Override
        protected void engineUpdate(byte[] b, int offset, int length) {
            for (int i = 0; i < length; i++){
                engineUpdate(b[i + offset]);
            }
        }

        /**
         * 每次执行{@link MessageDigest#digest()}时，都会获取之前计算好的结果。
         * 同时也会将数据置为初始状态。
         */
        @Override
        protected byte[] engineDigest() {
            while (count != 0){
                engineUpdate((byte) 0);
            }
            byte b[] = new byte[4];
            b[0] = (byte) (hash >>> 24);
            b[1] = (byte) (hash >>> 16);
            b[2] = (byte) (hash >>>  8);
            b[3] = (byte) (hash >>>  0);
            engineReset();
            return b;
        }

        /**
         * 数据转为初始状态
         */
        @Override
        protected void engineReset() {
            hash = 0;
            store = 0;
            count = 0;
        }

    }

