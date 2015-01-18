package sudoku;

import java.util.Random;
import java.util.Scanner;

public class KolaySudoku implements SudokuOlusturmaYontemi {

	
	
	private static int [][] rnd_degerler=new int[9][2];
    public static int sayac=0; 
    public static int sayac2=0;
    public static Random random =new Random();
    public static int[][] matris=new int[9][9];

    @Override
	public void ilkOlustur() {
		Scanner scan =new Scanner(System.in);
		
		System.out.println("\nSUDOKU UYGULAMASI\n");
		for (int i = 0; i < 9; i++) {
			do {
				rnd_degerler[i][0] = (random.nextInt(10)) - 1;
			} while (rnd_degerler[i][0] < 0);
			do {
				rnd_degerler[i][1] = (random.nextInt(10)) - 1;
			} while (rnd_degerler[i][1] < 0);
			
			for (int j = 0; j < 9; j++) {
				if (j == rnd_degerler[i][0] || j == rnd_degerler[i][1]) {
					System.out.print("# ");
					sayac++;
				} else
					System.out.print(mySudoku.sudoku[i][j] + " ");
				if (j == 2 || j == 5)
					System.out.print("|");
			}
			System.out.println();
			if (i == 2 || i == 5)
				System.out.println("------ ------ ------");
		}

		int deger = 1;
		int satýr;
		int sutun;
		while (deger != 0 || sayac != sayac2) {
			do {
				System.out.print("Satir giriniz:");
				satýr = scan.nextInt();
			} while (satýr < 1 || satýr > 9);
			do {
				System.out.print("Sütun giriniz:");
				sutun = scan.nextInt();
			} while (sutun < 1 || sutun > 9);
			do {
				System.out.print("Deger giriniz(Deger 0 girildiðinde oyun biter):");
				deger = scan.nextInt();
			} while (deger < 0 || deger > 9);
			if (deger == 0) {
				break;
			}
			if (deger == mySudoku.sudoku[satýr - 1][sutun - 1]) {
				matris[satýr - 1][sutun - 1] = deger;
				sayac2++;
				if(sayac==sayac2)
				{mySudoku.yazdir();break;}
				mySudoku.yazdir();
			} else {
				System.out.println("*******************YANLIS DEGER GIRDINIZ******************");
				mySudoku.yazdir();
			}

		}
		if (sayac == sayac2)
			System.out.println("**************TEBRIKLER DOÐRU ÇÖZDÜNÜZ*************");
		else if (deger == 0)
			System.out.println("*************OYUNU IPTAL ETTÝNÝZ*************");
	}
    
    
    @Override
    public  void yazdir(int sudoku[][]){
    	
    	
    	for (int i = 0; i < 9; i++) 
    	{
    	    for (int j = 0; j < 9; j++) {
			if(j==rnd_degerler[i][0] || j==rnd_degerler[i][1])
			{    if(matris[i][j]==0)System.out.print("# ");
			     else System.out.print(matris[i][j]+" ");
			}
			else
			System.out.print(sudoku[i][j] + " ");
			if(j==2 || j==5)
				System.out.print("|");
		}
		System.out.println();
		if(i==2 || i==5)
			System.out.println("------ ------ ------");
	}
    }

}
