package sudoku;

public class mySudoku {

	public static int[][] sudoku ;
	public static int[] rakamlar = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	
	public SudokuOlusturmaYontemi yontem;
	
	private static mySudoku yeni;
	
	 private mySudoku()
	 {
		 sudoku = new int[9][9];
	 }
    public static mySudoku getmySudoku(SudokuOlusturmaYontemi yontem)
    {
    	if(yeni==null)
    	{yeni=new mySudoku();
    	 yeni.yontem=yontem;
    	}
    	
    	return yeni;
    }
    
	public static void ilkOlustur()
	{
		yeni.yontem.ilkOlustur();
	}
    public static void yazdir()
    {
    	yeni.yontem.yazdir(sudoku);
    }
	public static void initSudoku() {

		boolean kontrol = true;
		for (int i = 1; i < 9; i++) {

			kontrol = true;
			for (int j = 0; j < 9; j++) {// 1.rakam
				if (uygunuMu(i, 0, getRakamlar()[j]) && kontrol) {
					sudoku[i][0] = getRakamlar()[j];

					for (int j2 = 0; j2 < getRakamlar().length; j2++) {// 2.rakam
						if (uygunuMu(i, 1, getRakamlar()[j2]) && kontrol) {
							sudoku[i][1] = getRakamlar()[j2];

							for (int k = 0; k < getRakamlar().length; k++) {// 3.rakam
								if (uygunuMu(i, 2, getRakamlar()[k]) && kontrol) {
									sudoku[i][2] = getRakamlar()[k];

									for (int k2 = 0; k2 < getRakamlar().length; k2++) {// 4.rakam
										if (uygunuMu(i, 3, getRakamlar()[k2])
												&& kontrol) {
											sudoku[i][3] = getRakamlar()[k2];

											for (int l = 0; l < getRakamlar().length; l++) {// 5.rakam
												if (uygunuMu(i, 4, getRakamlar()[l])
														&& kontrol) {
													sudoku[i][4] = getRakamlar()[l];

													for (int l2 = 0; l2 < getRakamlar().length; l2++) {// 6.rakam
														if (uygunuMu(i, 5,
																getRakamlar()[l2])
																&& kontrol) {
															sudoku[i][5] = getRakamlar()[l2];

															for (int m = 0; m < getRakamlar().length; m++) {// 7.rakam
																if (uygunuMu(
																		i,
																		6,
																		getRakamlar()[m])
																		&& kontrol) {
																	sudoku[i][6] = getRakamlar()[m];

																	for (int m2 = 0; m2 < getRakamlar().length; m2++) {// 8.rakam
																		if (uygunuMu(
																				i,
																				7,
																				getRakamlar()[m2])
																				&& kontrol) {
																			sudoku[i][7] = getRakamlar()[m2];

																			for (int n = 0; n < getRakamlar().length; n++) {// 9.rakam
																				if (uygunuMu(
																						i,
																						8,
																						getRakamlar()[n])
																						&& kontrol) {
																					sudoku[i][8] = getRakamlar()[n];
																					kontrol = false;

																					break;
																				} else if (kontrol
																						&& n == 8) {
																					sudoku[i][8] = 0;
																				}
																			}
																		} else if (kontrol
																				&& m2 == 8) {
																			sudoku[i][7] = 0;
																			sudoku[i][8] = 0;
																		}
																	}
																} else if (kontrol
																		&& m == 8) {
																	sudoku[i][6] = 0;
																	sudoku[i][7] = 0;
																	sudoku[i][8] = 0;
																}
															}
														} else if (kontrol
																&& l2 == 8) {
															sudoku[i][5] = 0;
															sudoku[i][6] = 0;
															sudoku[i][7] = 0;
															sudoku[i][8] = 0;
														}
													}
												} else if (kontrol && l == 8) {
													sudoku[i][4] = 0;
													sudoku[i][5] = 0;
													sudoku[i][6] = 0;
													sudoku[i][7] = 0;
													sudoku[i][8] = 0;
												}
											}
										} else if (kontrol && k2 == 8) {
											sudoku[i][3] = 0;
											sudoku[i][4] = 0;
											sudoku[i][5] = 0;
											sudoku[i][6] = 0;
											sudoku[i][7] = 0;
											sudoku[i][8] = 0;
										}
									}
								} else if (kontrol && k == 8) {
									sudoku[i][2] = 0;
									sudoku[i][3] = 0;
									sudoku[i][4] = 0;
									sudoku[i][5] = 0;
									sudoku[i][6] = 0;
									sudoku[i][7] = 0;
									sudoku[i][8] = 0;
								}
							}

						} else if (kontrol && j2 == 8) {
							sudoku[i][1] = 0;
							sudoku[i][2] = 0;
							sudoku[i][3] = 0;
							sudoku[i][4] = 0;
							sudoku[i][5] = 0;
							sudoku[i][6] = 0;
							sudoku[i][7] = 0;
							sudoku[i][8] = 0;
						}
					}
				} else if (kontrol && j == 8) {
					sudoku[i][0] = 0;
					sudoku[i][1] = 0;
					sudoku[i][2] = 0;
					sudoku[i][3] = 0;
					sudoku[i][4] = 0;
					sudoku[i][5] = 0;
					sudoku[i][6] = 0;
					sudoku[i][7] = 0;
					sudoku[i][8] = 0;
				}

			}
		}

	}

	public static boolean uygunuMu(int i, int j, int sayi) {

		boolean sonuc = false;

		int metot1 = 0, metot2 = 0, metot3 = 0;

		metot1 = satirdaVarmi(i, sayi);
		if (metot1 == 1) {
			metot2 = sutundaVarmi(j, sayi);
			if (metot2 == 1)
				metot3 = kutudaVarmi(i, j, sayi);
		}

		if ((metot1 * metot2 * metot3) == 0) {
			sonuc = false;
		} else {
			sonuc = true;
		}

		return sonuc;
	}

	private static int satirdaVarmi(int i, int sayi) {
		int sonuc = 0;
		for (int k = 0; k < 9; k++)
			if (sudoku[i][k] == sayi) {
				sonuc = 0;
				break;
			} else
				sonuc = 1;
		return sonuc;
	}

	private static int sutundaVarmi(int j, int sayi) {
		int sonuc = 0;
		for (int k = 0; k < 9; k++)
			if (sudoku[k][j] == sayi) {
				sonuc = 0;
				break;
			} else
				sonuc = 1;
		return sonuc;
	}

	private static int kutudaVarmi(int i, int j, int sayi) {

		int sonuc = 1;
		if (0 <= i && i <= 2 && 0 <= j && j <= 2) {
			sonuc = kutuyuTara(0, 0, 2, 2, sayi);
		} else if (0 <= i && i <= 2 && 3 <= j && j <= 5) {
			sonuc = kutuyuTara(0, 3, 2, 5, sayi);
		} else if (0 <= i && i <= 2 && 6 <= j && j <= 8) {
			sonuc = kutuyuTara(0, 6, 2, 8, sayi);
		}
		else if (3 <= i && i <= 5 && 0 <= j && j <= 2) {
			sonuc = kutuyuTara(3, 0, 5, 2, sayi);
		} else if (3 <= i && i <= 5 && 3 <= j && j <= 5) {
			sonuc = kutuyuTara(3, 3, 5, 5, sayi);
		} else if (3 <= i && i <= 5 && 6 <= j && j <= 8) {
			sonuc = kutuyuTara(3, 6, 5, 8, sayi);
		}
		else if (6 <= i && i <= 8 && 0 <= j && j <= 2) {
			sonuc = kutuyuTara(6, 0, 8, 2, sayi);
		} else if (6 <= i && i <= 8 && 3 <= j && j <= 5) {
			sonuc = kutuyuTara(6, 3, 8, 5, sayi);
		} else if (6 <= i && i <= 8 && 6 <= j && j <= 8) {
			sonuc = kutuyuTara(6, 6, 8, 8, sayi);
		}

		return sonuc;
	}

	private static int kutuyuTara(int i1, int j1, int i2, int j2, int sayi) {

		int sonuc = 1;
		for (int i = i1; i <= i2; i++)
			for (int j = j1; j <= j2; j++) {
				if (sudoku[i][j] == sayi) {
					sonuc = 0;
					break;
				}
			}
		return sonuc;
	}

	public static void karistir(int[] arr) {
    
		for (int i = 0; i < arr.length; i++) {
			int randNum;
			int temp;

			randNum = (int) (Math.random() * arr.length);
			temp = arr[i];
			arr[i] = arr[randNum];
			arr[randNum] = temp;
		}
		int a=0;//iterator pattern 
		for (Object item : arr)
		{  sudoku[0][a]=(Integer) item;
		   a++;
		}
		//for (int i = 0; i < arr.length; i++)
			//sudoku[0][i] = arr[i];

	}
	public static void setRakamlar(int[] rakamlar) {
		mySudoku.rakamlar = rakamlar;
	}
	public static int[] getRakamlar() {
		return rakamlar;
	}
}
