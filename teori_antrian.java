package teksim;
import java.util.Scanner;

/**
 *
 * @author Diva
 */
public class teori_antrian {
    public static void main(String[] args) {
        double u1,u2;
        int z=1;
        int tes=1;
        int kurang=1;
        Scanner input = new Scanner(System.in);
        boolean next=true;
        
        
        while (next){
            int n=1;
            int j=1;
            int i=1;
            double luas=0;
            System.out.println("         SINGLE-SERVER QUEUEING SYSTEM        ");
            System.out.println("\nDibuat oleh :");
            System.out.println("1.Fransisca Diva Amadea (06111740000005)\n" + "2.Miftakhul Janah Seftia A.(06111740000014)\n" + "3.Karohmatul Amalia MS (06111740000027)");
            System.out.print("\nPilih yang diketahui: " 
                    +"\n1. Jumlah kastemer" 
                    +"\n2. Waktu simulasi" 
                    +"\n\nPilihan anda\t: ");
            int pilihan = input.nextInt();
            switch(pilihan){
                case 1 :
                    tes=1;
                    z=1;
                    boolean cek = false;
                    System.out.print("\nMasukkan jumlah kastemer\t: ");
                    int jumlah = input.nextInt();   
                    
                    System.out.print("Masukkan rata-rata waktu antar kedatangan kastemer (β1)\t: ");
                    int beta1 = input.nextInt();    
                    System.out.print("Masukkan rata-rata waktu pelayanan kastemer (β2)\t: ");
                    int beta2 = input.nextInt(); 
                    
                    while(cek==false){
                        if(beta2>beta1)
                            cek=true;
                        else{
                            System.out.println("\tβ2 harus lebih besar daripada β1!");
                            System.out.print("Masukkan rata-rata waktu antar kedatangan kastemer (β1)\t: ");
                            beta1 = input.nextInt();    
                            System.out.print("Masukkan rata-rata waktu pelayanan kastemer (β2)\t: ");
                            beta2 = input.nextInt(); }
                    }
                    double[] t1 = new double[jumlah+2];
                    double[] A1 = new double[jumlah+2];
                    double[] S1 = new double[jumlah+2];
                    double[] c1 = new double[jumlah+2];
                    int[] n1 = new int[jumlah+2];
                    
                    System.out.print("Masukkan waktu awal kedatangan kastemer\t: ");
                    t1[0] = input.nextInt();
                    luas=t1[0];
                
                    System.out.println("\nTabel data waktu kedatangan dan waktu pelayanan kastemer secara berurutan");
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("i\tti\t\tAi\t\tSi\t\tci\t\tn\t");
                    System.out.println("---------------------------------------------------------------------------");
                    
                    while (i<=jumlah){
                        n1[0]=0;
                        n1[1]=1;
                        u1 = Math.random();
                        
                        while(u1==0.00){
                            u1 = Math.random();
                        }
                        double ln1 = Math.log(u1);
                        double ln2 = Math.log(u1);
                        A1[i] = -1*beta1*ln1;              
                        S1[i] = -1*beta2*ln2;
                        t1[i] =t1[i-1]+A1[i-1];
                        if(c1[i-1]<t1[i])
                            c1[i] = t1[i] + S1[i];
                        else
                            c1[i] = t1[i] + S1[i] + (c1[i-1]-t1[i]);
                        
                        while(j<=i){
                            if(c1[j-1]<=t1[i]){
                                if(n1[i]>1)
                                    n1[i]--;
                                else
                                    n1[i]=1;}
                            else
                                    n1[i]++;
                            j++;
                        }
                        luas=luas+((t1[i]-t1[i-1])*n1[i]);
                        
                        for(int k=1;k<=i;k++){
                            for(z=tes;z<=k;z++){
                                if(c1[z]>t1[k] && c1[z]<t1[k+1]){
                                    System.out.println("\t"+String.format("%.4f",c1[z])+"\t\t\t\t\t\t\t\t"+(n1[k]-kurang));
                                    tes++;
                                    kurang++;
                                    luas=luas+(c1[z]-t1[k])*kurang;
                            }
                                
                          }
                             kurang=1;
                        }
                       
                        System.out.println(" " +i+"\t" +String.format("%.4f",t1[i])+"\t\t" +
                                String.format("%.4f",A1[i])+"\t\t"+String.format("%.4f",S1[i])+
                                "\t\t"+String.format("%.4f",c1[i])+"\t\t"+n1[i]+"\t");
                        i++;
                        n1[i]=1;
                        j=1;
                    }
                            
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("Luas\t\t\t\t\t: "+String.format("%.4f",luas));
                    System.out.println("Rata-rata jumlah kastemer dalam sistem\t: "+String.format("%.4f",luas/t1[i-1]));
                    System.out.println("Rata-rata waktu kastemer dalam sistem\t: "+String.format("%.4f",luas/(i-1)));
                    break;
                    
                case 2:
                    tes=1;
                    kurang=1;
                    cek = false;
                    System.out.print("\nMasukkan waktu simulasi\t: ");
                    int waktu = input.nextInt();  
                    System.out.print("Masukkan rata-rata waktu antar kedatangan kastemer (β1)\t: ");
                    beta1 = input.nextInt();    
                    System.out.print("Masukkan rata-rata waktu pelayanan kastemer (β2)\t: ");
                    beta2 = input.nextInt(); 
                    
                    while(cek==false){
                        if(beta2>beta1)
                            cek=true;
                        else{
                            System.out.println("\tβ2 harus lebih besar daripada β1!");
                            System.out.print("Masukkan rata-rata waktu antar kedatangan kastemer (β1)\t: ");
                            beta1 = input.nextInt();    
                            System.out.print("Masukkan rata-rata waktu pelayanan kastemer (β2)\t: ");
                            beta2 = input.nextInt(); }
                    }
                    
                    double[] t2 = new double[90];
                    double[] A2 = new double[90];
                    double[] S2 = new double[90];
                    double[] c2 = new double[90];
                    int[] n2 = new int[90];
                    
                    System.out.print("Masukkan waktu awal kedatangan kastemer\t: ");
                    t2[0] = input.nextInt();
                    luas=t2[0];
                
                    System.out.println("\nTabel data waktu kedatangan dan waktu pelayanan kastemer secara berurutan");
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("i\tti\t\tAi\t\tSi\t\tci\t\tn\t");
                    System.out.println("---------------------------------------------------------------------------");
                    
                    while (t2[i-1]<=waktu){
                        n2[0]=0;
                        n2[1]=1;
                        u2 = Math.random();
                        
                        while(u2==0.000){
                            u2 = Math.random();
                        }
                        double ln1 = Math.log(u2);
                        double ln2 = Math.log(u2);
                        A2[i] = -1*beta1*ln1;              
                        S2[i] = -1*beta2*ln2;
                        t2[i] = t2[i-1]+A2[i-1];
                        if(c2[i-1]<t2[i])
                            c2[i] = t2[i] + S2[i];
                        else
                            c2[i] = t2[i] + S2[i] + (c2[i-1]-t2[i]);
                        
                        while(j<=i){
                            if(c2[j-1]<=t2[i]){
                                if(n2[i]>1)
                                    n2[i]--;
                                else
                                    n2[i]=1;}
                            else
                                    n2[i]++;
                            j++;
                        }
                        luas=luas+(t2[i]-t2[i-1])*n2[i-1];
                        for(int k=1;k<=i;k++){
                            for(z=tes;z<=k;z++){
                                if(c2[z]>=t2[k] && c2[z]<=t2[k+1]){
                                    System.out.println("\t"+String.format("%.4f",c2[z])+"\t\t\t\t\t\t\t\t"+(n2[k]-kurang));
                                    tes++;
                                    kurang++;
                            }
                                
                          }
                             kurang=1;
                        }
                        if(t2[i]<waktu)
                            System.out.println(" " +i+"\t" +String.format("%.4f",t2[i])+"\t\t" +
                                String.format("%.4f",A2[i])+"\t\t"+String.format("%.4f",S2[i])+
                                "\t\t"+String.format("%.4f",c2[i])+"\t\t"+n2[i]+"\t ");
                        i++;
                        n2[i]=1;
                        j=1;
                    }
                    System.out.println("---------------------------------------------------------------------------");
                    System.out.println("Luas\t\t\t\t\t: "+String.format("%.4f",luas));
                    System.out.println("Rata-rata jumlah kastemer dalam sistem\t: "+String.format("%.4f",luas/waktu));
                    System.out.println("Rata-rata waktu kastemer dalam sistem\t: "+String.format("%.4f",luas/(i-2)));
                    break;
                    
                default :
                System.out.println("Maaf, pilihan anda tidak tersedia");     
                    }
            
            System.out.print("\nIngin coba lagi?\n1. Ya\n2. Tidak \n\nPilihan anda\t: ");
            int coba = input.nextInt();
            switch (coba) {
                case 1 :
                    System.out.println("\n\n");
                    break;
                case 2 :
                    next=false;
                    System.out.println("\n     Terimakasih sudah mencoba :)     ");
                    break;
                default :
                    System.out.println("Pilihan anda tidak tersedia\n");
                    next=false;
                    System.out.println("\n     Terimakasih sudah mencoba :)     ");
                   
            }       
            
          }
        

        }     
    }
   
