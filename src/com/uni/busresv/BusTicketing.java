package com.uni.busresv;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BusTicketing  {

    public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String user,password,yn,search,again,choice;
    int to=0,y=1,z=0,end=0,r=1;
    int available[] = new int[6];
    int ticketI[][] = new int [100][3];
    String ticketS[][] = new String[100][3];
    double ticketD[][] = new double [100][3];
    double pay[] = new double[20];
    double change[] = new double[20];
    
    
    for(int i=1;i<4;){
		System.out.print("아이디 입력: ");
		user = in.readLine();
		System.out.print("비밀번호 입력: ");
		password = in.readLine();
    
    	
    	for(int o=1; o<=5; o++){
    		available[o]=60;
  		}
    
    	
    	if(user.equals("333") && password.equals("333")){
    	
    		for(int x=1; x==1;){
    			System.out.println("** Java World shuttle bus ticketing  **");
    			System.out.println(" 1. 버스 정거장 조회 ");
    			System.out.println(" 2. 버스 티켓 예메 ");
    			System.out.println(" 3. 버스 티켓 계산");
    			System.out.println(" 4. 탑승객 티켓 구매 조회");
    			System.out.println(" 0. 프로그램 종료");
    			
    	
    			for(x=1; x==1;){
					System.out.print("번호를 입력해주세요 : ");
					choice=in.readLine();
					
					
					if (choice.equals("1")){
						
						
    					System.out.println("** 도착정보   | 티켓가격|  좌석  **");
    					System.out.println(" 1.AA      | 10000 |   "+available[1]);
    					System.out.println(" 2.BB      | 10000 |   "+available[2]);
    					System.out.println(" 3.CC      | 10000 |   "+available[3]);
    					System.out.println(" 4.DD      | 10000 |   "+available[4]);
    					System.out.println("-------------------------------------");
    					System.out.println("가격 할인 기준: 어린이 & 노인 20% 활인\n");	
    					
    					System.out.println("*****************************************");
    					System.out.println("****       AA 정거장에서 Java 월드        ****");
    					System.out.println("**  매주 월~금: 매 시 50분 일정으로 출발 예정    **");
    					System.out.println("*========================================*");
    					System.out.println("****       BB 정거장에서 Java 월드        ****");
    					System.out.println("**  매주 월~금: 매 시 50분 일정으로 출발 예정    **");
    					System.out.println("*========================================*");
    					System.out.println("****       CC 정거장에서 Java 월드        ****");
    					System.out.println("**  매주 월~금: 매 시 50분 일정으로 출발 예정    **");
    					System.out.println("*========================================*");
    					System.out.println("****       DD 정거장에서 Java 월드        ****");
    					System.out.println("**  매주 월~금: 매 시 50분 일정으로 출발 예정    **");
    					System.out.println("*****************************************");
    					x=0;
					}
					
					
					else if (choice.equals("2")){
						int print=1;
						
						
						
						
						System.out.println("** 도착정보   | 티켓가격|  좌석  **");
    					System.out.println(" 1.AA      | 10000 |   "+available[1]);
    					System.out.println(" 2.BB      | 10000 |   "+available[2]);
    					System.out.println(" 3.CC      | 10000 |   "+available[3]);
    					System.out.println(" 4.DD      | 10000 |   "+available[4]);
    					System.out.println("-------------------------------------");
    					System.out.println("어린이 & 노인 20% 활인\n");
    					
    					if((available[1]==0)&&(available[2]==0)&&(available[3]==0)&&(available[4]==0)&&(available[5]==0)){
    						System.out.println("죄송합니다. 현재 모든 좌석이 매진입니다.");
    						x=0;
    						
    					}
    					
    					
    					
    					//inputing of Passenger's Name//
    					else{
    					for(x=1; x==1;){
    						System.out.print("탑승객 이름: ");
    						ticketS[z][0] = in.readLine();
							
							x=0;
							
							
    						for(int l=0; l<z; l++){
    							if(ticketS[l][0].equalsIgnoreCase(ticketS[z][0])){
    								System.out.println("이미 구해만 탑승자입니다.");
    								x=1;
    							}
    						}
    					}
    					
    					
    					for(x=1; x==1;){
    						System.out.print("도착 정거장 입력 (숫자입력): ");
    						to = Integer.parseInt(in.readLine());
    						
    						
    						if(to<1 || to>5){
    							System.out.println("입력이 불가능합니다.");
    							x=1;
    						}
    						
    						for(int d=1; d<=5; d++){
    							if(to==d){
    								if(available[to]==0){
    									System.out.println("죄송합니다 현재 좌석이 없습니다.");
    									x=1;
    								}
    								x=0;
    							}
    						}
    					}
    					
    					
    					String dest[] = { " ", "AA", "BB", "CC", "DD"};
    					double fare[] = { 0,10000,10000,10000,10000,10000};
    		
    					
    					ticketS[z][1] = dest[to];
    					ticketD[z][0] = fare[to];
    					
    					
    					for(x=1; x==1;){
    					System.out.print("탑승객 명수 입력: ");
    					ticketI[z][0] = Integer.parseInt(in.readLine());
    		
    						
    						for(int p=1; p<=5; p++){
    							if(to==p){
    								print=1;
    								available[to] = available[to]-ticketI[z][0];
    								
    								
    								if(available[to]<0){
    									System.out.print("죄송합니다 현재 " +ticketI[z][0] +" 명분의 좌석이 없습니다.");
    									available[to] = available[to]+ticketI[z][0];
    									System.out.print("우리는 오직 " +available[to] +" 명분의 좌석이 예약이 가능합니다.");
    									x=1;
    									print=0;
    								}
    								else{
    									x=0;
    								}
    							}
    						}
    		
    					}
    					
    					
    					for(x=1;x==1;){
    						System.out.print("할인 받을 수 있는 사람 명수 입력: ");
    						ticketI[z][1] = Integer.parseInt(in.readLine());
    					
    						if(ticketI[z][1]>ticketI[z][0]){
    							
    							System.out.println("잘못입력했습니다.");
    							System.out.println("손님은 " +ticketI[z][0] +"!");
    						x=1;
    						}
    						else{
    							break;
    						}
    					}
    		
    		
    					
    					if(print==1){
    						System.out.println("**        탑승객 정보       **");
    						System.out.println("탑승객 이름: " + ticketS[z][0]);
    						System.out.println("탑승객 도착정보 : " + ticketS[z][1]);
    						System.out.println("티켓 가격: " + ticketD[z][0]);
    						System.out.println("탑승객 명수: " + ticketI[z][0]);
    						System.out.println("할인 받은 탑승객 명수: " + ticketI[z][1]);
    						ticketS[z][2]="0";
    						double discount=(ticketD[z][0]-(ticketD[z][0]*0.2))*ticketI[z][1];
    						ticketD[z][2]= ((ticketI[z][0]-ticketI[z][1])*ticketD[z][0])+discount;
    						x=0;
    					}
    					z++;
    					}
					}
					
					else if (choice.equals("3")){
			          
			            
						for(x=1; x==1;){
							
								System.out.print("탑승객 이름 입력: ");
								search = in.readLine();
								
								
								int s=1;
								for(int b=0;b<z;b++){
									if(search.equalsIgnoreCase(ticketS[b][0])){
	    								System.out.println("**        탑승객 정보       **");
	    								System.out.println("탑승객 이름: " + ticketS[z][0]);
	    	    						System.out.println("탑승객 도착정보 : " + ticketS[z][1]);
	    	    						System.out.println("티켓 가격: " + ticketD[z][0]);
	    	    						System.out.println("탑승객 명수: " + ticketI[z][0]);
	    	    						System.out.println("할인 받은 탑승객 명수: " + ticketI[z][1]);
		 		   						System.out.println("***************************************");
	    								s=0;
										x=0;
										
										if(ticketS[b][2].equals("x")){
	    									System.out.println("이미 지불을 완료하였습니다.");
	    									x=0;
	    								}
	    								else{
	    									ticketS[b][2]="x";
	    									
	    								
	    									for(x=1; x==1;){
	    										System.out.println("\n탑승객 티켓 가격 : "+ticketD[b][2]);
	    										System.out.print("지불할 액수 입력: ");
	    										pay[b] = Double.parseDouble(in.readLine());
	    										change[b]=pay[b]-ticketD[b][2];
	    							
	    										if(change[b]<0){
	    											System.out.println("돈이 부족합니다.");
	    											x=1;
	    										}
	    										else{
	    											System.out.println("잔금 : "+change[b]);
	    											System.out.println("");
	    											x=0;
	    										}
	    									}
										}
									}
								}
								if (s==1){
									System.out.println("\n탑승객의 정보가 없습니다.!\n");
									for(int q=1; q==1;){
									
									System.out.print("계속 진행 하시겠습니까? [예/아니요]: ");
									again=in.readLine();
									
									if(again.equalsIgnoreCase("예")){
										q=0;
									}
									else if (again.equalsIgnoreCase("아니요")){
										q=0;
										x=0;
										
									}
									else{
										System.out.println("\n입력불가\n");
									}
								
						
								}
							}	
						}
			            
					}
					
					else if (choice.equals("4")){
						
						
						for(int sx=1; sx<=3;){
 						System.out.print("탑승객 이름 검색: ");
    					search = in.readLine();
    		    
    		 		   	int s=1;
							for(x=0; x<=z; x++){
								if(search.equalsIgnoreCase(ticketS[x][0])){
    								System.out.println("**        탑승객 정보       **");
    								System.out.println("탑승객 이름: " + ticketS[x][0]);
    								System.out.println("탑승객 도착지 : " + ticketS[x][1]);
    								System.out.println("티켓 가격 : " + ticketD[x][0]);
    								System.out.println("탑승객 명수: " + ticketI[x][0]);
    								System.out.println("할인 받는 탑승객 명수: " + ticketI[x][1]);
    								System.out.println("총 버스티켓 가격 " + ticketD[x][2]);
    								if(ticketS[x][2].equals("x")){
    									System.out.println("계산: " +pay[x]);
    									System.out.println("잔돈: " +change[x]);
    									System.out.println("상태: 결제 완료");
    								}
    								else{
    									System.out.println("상태: 미결재");
    								}
    								System.out.println("***************************************");
    								
    								s=0;
								    sx=4;
								}
							}	
						
							
							if (s==1){
								System.out.println("탑승객 정보가 없습니다.");
								sx++;
							}
							
				    	}
					}
					
					
					
					
					
					else if(choice.equals("0")){
						end=1;
						x=0;
						System.out.println("감사합니다.");
					}
				
					else{
						System.out.println("입력불가");
						x=1;
					}
    			}
    	
    			for(y=1; y==1;){
    				if(end==1){
    					break;
    				}
    				System.out.print("계속 진행하시겠습니까? [예/아니요]: ");
   				 	yn = in.readLine();
    	
    				if (yn.equalsIgnoreCase("예")){
    					x=1;
    					y=0;
    				}
    				else if (yn.equalsIgnoreCase("아니요")){
    					System.out.println("\n감사합니다.!!!");
    					break;
    				}
    				else{
    					System.out.println("입력불가!!!");
    					y=1;
    				}
    			}
    		}
    		i=4;
    	}
    	else{
    		System.out.println("\n 아이디와 비번이 틀렸습니다.\n");
    		i++;
		}
	
    }
    
    }



	
    
    
}