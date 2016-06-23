    public class Gauss
   {
	
   private  double[] x ;
  
	public Gauss(double [] x0)
	
	      {
	          x  = new double[x0.length];
			}
			
			
			
	    public static double nInf(double[] x)
      {  			
		double temp = 0;
         for(int i = 0 ; i < x.length ; i++)
         {
            if(temp<Math.abs(x[i]))
            {
               temp=Math.abs(x[i]);
            }
         }
         return temp;
      }
   
	
       public  void gauss(double[][] A , double[] b , double[] XO 
		 ,double  tol ,int N)
      {
         int k=1;
         while(k<=N)
         {
           
            
            for(int i=0 ; i<A.length ; i++)
            {
               double sum = 0;
					//double sum2 = 0;
               for(int j = 0 ; j<A.length ; j++)
               {
                  if(j>i)
                  {
					
                     sum += A[i][j]*XO[j];
						//	System.out.print("XO["+j+"]: " + XO[j]+" ; #");
                  }
						 if(j<i)
                  {
						   sum += A[i][j]*x[j];
						//	System.out.print("x["+j+"]: " + x[j]+" ; # ");
                  }
                  
               }
               x[i]=(-sum+b[i])/A[i][i];
					//System.out.println(i+"_:__"+x[i]);
					          	System.out.println("x["+i+"]: " + x[i]+" ;");
            	//System.out.println("x[i]: " + x[i]+" ;");
					//System.out.println("XO[i]: " + XO[i]+" ;");
            }
            System.out.println();
            
                     double[] rez = new double[XO.length];
            for(int i = 0 ; i<rez.length ; i++)
            {
               rez[i]=x[i]-XO[i];
            }
            double d = nInf(rez);
            if(d<tol)
            {
               for(int i = 0 ; i<x.length ; i++)
               {
                // System.out.println(i+"___"+x[i]);
               }
               System.exit(0);
            
            }
         	
            k=k+1;
         
            for(int i = 0 ; i<x.length ; i++)
            {
               XO[i]=x[i];
            }
         
         
         }
      System.out.println("Eshte tejkaluar numri maksimal i iteracioneve");
      }
      
   	public static void main(String[] args)
   	{
		//Jacobi ja= new Jacobi(XO);
      double[][] A={{10,-1,2,0},{-1,11,-1,3},{2,-1,10,-1},{0,3,-1,8}};
   	double[] b = {6,25,-11,15};
   	double[] XO = {0,0,0,0};
		Gauss ga= new Gauss(XO);
   	ga.gauss( A , b , XO ,1E-2,10 );
    
   	
   	}
   
   
   }