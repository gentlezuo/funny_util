

  /**
   * 随机移动鼠标指针
   */
    public class RandomMove {

        public static void randomMove() throws Exception {
            java.awt.Robot m1 = new java.awt.Robot();
            for (int i = 0 ; i <=100 ; i++){
                m1.mouseMove ( (int) (Math.random ()*1000),  (int) (Math.random ()*1000));
                Thread.sleep (200);
            }
        }


        public static void main (String[] args) throws Exception {
            RandomMove.randomMove();
        }
    }

