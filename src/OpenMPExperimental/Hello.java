package OpenMPExperimental;



/**
 * Created by marc on 05.02.17.
 */
public class Hello {

    public static void main (String[] args) {


//        public static void main(String[] args) {

            int foo = 5;
            // omp parallel
            {
                System.out.println("hello");
                System.out.println("world");
                System.out.println(foo);
            }

            System.out.println("last line");
        }

//        int foo = 5;
//
//		/* === OMP CONTEXT === */
//        class OMPContext {
//            public int local_foo;
//        }
//        final OMPContext ompContext = new OMPContext();
//        ompContext.local_foo = foo;
//        final org.omp4j.runtime.IOMPExecutor ompExecutor = new org.omp4j.runtime.DynamicExecutor(Runtime.getRuntime().availableProcessors());
///* === /OMP CONTEXT === */
//        for (int ompI = 0; ompI < Runtime.getRuntime().availableProcessors(); ompI++) {
//            ompExecutor.execute(new Runnable(){
//                @Override
//                public void run() {
//                    {
//                        System.out.println("hello");
//                        System.out.println("world");
//                        System.out.println(ompContext.local_foo);
//                    }		}
//            });
//        }
//        ompExecutor.waitForExecution();
//        foo = ompContext.local_foo;
//
//
//        System.out.println("last line");
//    }
}

