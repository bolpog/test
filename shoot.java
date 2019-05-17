package test;

public class shoot {

	int checkx;
	int checky;
	int lastHitx = -1;
	int lastHity = -1;

public void shoot()

	{
		int cpushootx = (int) (Math.random() * boardSize);
		int cpushooty = (int) (Math.random() * boardSize);

		if (lastHitx != -1 && lastHity != -1) {
			System.out.println("Last Hit not -1");
			
			if (playerRects[lastHitx][lastHity].getFill().equals(Color.GREEN)) {
				System.out.println("Doing some fancy stuff");
				
				Boolean legalSpace = false;
				while (legalSpace == false) {
					int randxy = (int) (Math.random() * 4);
					if (randxy == 0) {
						checkx = 1;
						checky = 0;
					}
	
					if (randxy == 1) {
						checkx = 0;
						checky = 1;
					}
	
					if (randxy == 2) {
						checkx = -1;
						checky = 0;
					}
	
					if (randxy == 3) {
						checkx = 0;
						checky = -1;
					}
					if (playerRects[lastHitx + checkx][lastHity + checky].getFill().equals(Color.BLUE) 
							|| playerRects[lastHitx + checkx][lastHity + checky].getFill().equals(Color.WHITE)) {
						legalSpace = true;
					}
				}
				
				System.out.println("Last Hit X" + " " + "=" + " " + lastHitx);
				System.out.println("Last Hit Y" + " " + "=" + " " + lastHity);
				
				
				if (playerRects[lastHitx + checkx][lastHity + checky].getFill().equals(Color.BLUE)) {
					System.out.println("Computer | HIT!" + " [" + (lastHitx + checkx) + ", " + (lastHity + checky) + "]");
					
					playerhit++;
					System.out.println("Player | Hit Count: " + playerhit);
	
					playerRects[lastHitx + checkx][lastHity + checky].setFill(Color.GREEN);
					return;
				}

				if (playerRects[lastHitx + checkx][lastHity + checky].getFill().equals(Color.WHITE)) {
					playerRects[lastHitx + checkx][lastHity + checky].setFill(Color.GREY);
					System.out.println("Computer | Miss" + " [" + (lastHitx + checkx) + ", " + (lastHity + checky) + "]");
					return;
				}
			}
		}

		else
			System.out.println("Last Hit is -1");
		
		 if (playerRects[cpushootx][cpushooty].getFill().equals(Color.WHITE)) 
		 {
				playerRects[cpushootx][cpushooty].setFill(Color.GREY);
				System.out.println("COMPUTER MISSED");

				lastHitx = -1;
				System.out.println("Last Hit X" + " " + "=" + " " + lastHitx);
				lastHity = -1;
				System.out.println("Last Hit Y" + " " + "=" + " " + lastHity);

				return;
			}
		
		 else if (playerRects[cpushootx][cpushooty].getFill().equals(Color.BLUE)) {
			System.out.println("COMPUTER HIT!");
			playerhit++;
			
			lastHitx = cpushootx;
			lastHity = cpushooty;
			
			playerRects[cpushootx][cpushooty].setFill(Color.GREEN);
			return; 
		} 
		
		 

	}
	
}
