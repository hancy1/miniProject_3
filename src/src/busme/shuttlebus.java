package busme;
import java.io.*;
public class shuttlebus {

    public static void main(String args[]) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    
    String user,password,yn,search,again,choice;
    int to=0,y=1,z=0,end=0,r=1;
    int available[] = new int[6];
    int ticketI[][] = new int [100][3];
    String ticketS[][] = new String[100][3];
    double ticketD[][] = new double [100][3];
    
 
    
    for(int i=1;i<4;){
		System.out.print("Enter Username: ");
		user = in.readLine();
		System.out.print("Enter Password: ");
		password = in.readLine();
    
    	//"available[]" is the SEAT AVAILABLE//
		//store 20 seats every destination [1-5]//
    	for(int o=1; o<=5; o++){
    		available[o]=60;
  		}
    
    	//if user and password are correct proceed to MAIN MENU//
    	if(user.equals("1") && password.equals("1")){
    	
    		for(int x=1; x==1;){
    			//the MAIN MENU//
    			System.out.println("== 자바월드 버스 예약 시스템==");
    			System.out.println("1. 버스정거장 조회");
    			System.out.println("2. 버스 좌석 예약");
    			System.out.println("3. 버스 티켓 조회");
    			System.out.println("0. 프로그램 종료");
    			
    	
    			for(x=1; x==1;){
					System.out.print("번호를 입력해주세: ");
					choice=in.readLine();
					
					
					if (choice.equals("1")){
						
						System.out.println("== 자바월드 버스정거장 조회==");
						System.out.println(" 1.)서울역  |   "+available[1]);
    					System.out.println(" 2.)강남역  |   "+available[2]);
    					System.out.println(" 3.)논현역  |  "+available[3]);
    					System.out.println(" 4.)시청역  |  "+available[4]);
    					System.out.println(" 5.)      |  "+available[5]);
    					x=0;
					}
					
					
					else if (choice.equals("2")){
						int print=1;
						
						
						
						
						System.out.println("== 자바월드 버스정거장 예약==");
						System.out.println(" 1.)서울역  |   "+available[1]);
    					System.out.println(" 2.)강남역  |   "+available[2]);
    					System.out.println(" 3.)논현역  |  "+available[3]);
    					System.out.println(" 4.)시청역  |  "+available[4]);
    					System.out.println(" 5.)      |  "+available[5]);
    				
    					
    					
    					if((available[1]==0)&&(available[2]==0)&&(available[3]==0)&&(available[4]==0)&&(available[5]==0)){
    						System.out.println("죄송합니다. 현재 좌석이 매진 되었습니다.");
    						x=0;
    						
    					}
    					
    					
    					
    					//inputing of Passenger's Name//
    					else{
    					for(x=1; x==1;){
    						System.out.print("\n승객의이름을 입력해주세요: ");
    						ticketS[z][0] = in.readLine();
							
							x=0;
							
							//if Passenger's Name already used, display error and go back to Inputing//
    						for(int l=0; l<z; l++){
    							if(ticketS[l][0].equalsIgnoreCase(ticketS[z][0])){
    								System.out.println("이름이 이미 존재합니다.");
    								x=1;
    							}
    						}
    					}
    					
    					//inputing of Destination//
    					//integers Only [1-5]//
    					for(x=1; x==1;){
    						System.out.print("도착 정거장를 입력해주세요 (번호): ");
    						to = Integer.parseInt(in.readLine());
    						
    						//if Inputed integers are "<1" or ">5", display error and go back to Inputing//
    						if(to<1 || to>5){
    							System.out.println("잘못입력했습니다.");
    							x=1;
    						}
    						//if available seat is eqaul to "Zero", display error and go back to Inputing//
    						for(int d=1; d<=5; d++){
    							if(to==d){
    								if(available[to]==0){
    									System.out.println("죄송합니다. 현재 좌석이 없습니다.");
    									x=1;
    								}
    								x=0;
    							}
    						}
    					}
    					
    					//convert the integer to string//
    					String dest[] = { " ", "서울역", "강남역", "논현역", "시청역", "CAGAYAN"};
    					
    		
    					//converted integer to string, transfer to storage array//
    					ticketS[z][1] = dest[to];
    				
    					
    					//inputing for Number of Passenger's//
    					for(x=1; x==1;){
    					System.out.print("승객의 수를 입력해주세요: ");
    					ticketI[z][0] = Integer.parseInt(in.readLine());
    		
    						//subtract the available seat by the the number inputed//
    						for(int p=1; p<=5; p++){
    							if(to==p){
    								print=1;
    								available[to] = available[to]-ticketI[z][0];
    								
    								//if the subtracted available seat is "<0", display error//
    								//add the inputed number to the subtracted seat, to back the original seat//
    								//display the available seat and back to the inputing//
    								if(available[to]<0){
    									System.out.print("죄송합니다. 저희는 현재 " +ticketI[z][0] +" 만큼의 좌석이 없습니다.\\n");
    									available[to] = available[to]+ticketI[z][0];
    									System.out.print("우리는 지금 현재 " +available[to] +" 만큼 좌속이 있습니다.\n");
    									x=1;
    									print=0;
    								}
    								else{
    									x=0;
    								}
    							}
    						}
    		
    					}
    					
    					
    	
    		
    					//print out of passengers details....
    					if(print==1){
    						System.out.println("예약자 정보");
    						System.out.println("승객이름: " + ticketS[z][0]);
    						System.out.println("승객 도착 정거장 : " + ticketS[z][1]);
    						System.out.println("탑승객 수: " + ticketI[z][0]);
    						ticketS[z][2]="0";
    						x=0;
    					}
    					z++;
    					}
					}
					
					else if (choice.equals("3")){
			          
			            
						for(x=1; x==1;){
							
								System.out.print("ENTER PASSENGER'S NAME: ");
								search = in.readLine();
								
								
								int s=1;
								for(int b=0;b<z;b++){
									if(search.equalsIgnoreCase(ticketS[b][0])){
										System.out.println("예약자 정보");
										System.out.println("승객이름: " + ticketS[z][0]);
			    						System.out.println("승객 도착 정거장 : " + ticketS[z][1]);
			    						System.out.println("탑승객 수: " + ticketI[z][0]);
	    								s=0;
										x=0;
										
										if(ticketS[b][2].equals("x")){
	    									System.out.println("티켓 신청이 완료되었습니다.");
	    									x=0;
	    								}
	    								else{
	    									ticketS[b][2]="x";
	    									
	    								
	    									
										}
									}
								}
								if (s==1){
									System.out.println("\n탑승객의 정보가 없습니다.\n");
									for(int q=1; q==1;){
									
									System.out.print("계속 진행하시겠습니? [Y/N]: ");
									again=in.readLine();
									
									if(again.equalsIgnoreCase("y")){
										q=0;
									}
									else if (again.equalsIgnoreCase("n")){
										q=0;
										x=0;
										
									}
									else{
										System.out.println("입력을 잘못하였습니다.");
									}
								
						
								}
							}	
						
			            
						else if(choice.equals("5")){
							end=1;
							x=0;
							System.out.println("Thank You!");
						}
					
						else{
							System.out.println("Invalid Input!");
							x=1;
						}
	    			}
	    	
	    			for(y=1; y==1;){
	    				if(end==1){
	    					break;
	    				}
	    				System.out.print("Do you want another transaction? [Y/N]: ");
	   				 	yn = in.readLine();
	    	
	    				if (yn.equalsIgnoreCase("y")){
	    					x=1;
	    					y=0;
	    				}
	    				else if (yn.equalsIgnoreCase("n")){
	    					System.out.println("\nThank You!!!");
	    					break;
	    				}
	    				else{
	    					System.out.println("Invalid Input!!!");
	    					y=1;
	    				}
	    			}
	    		}
	    		i=4;
	    	}
    	}
    	}
	    	else{
	    		System.out.println("\nInvalid user or password!\n");
	    		i++;
			}
		
	    }
    }
}
 
