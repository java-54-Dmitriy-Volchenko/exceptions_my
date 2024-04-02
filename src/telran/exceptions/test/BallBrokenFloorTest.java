package telran.exceptions.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.exceptions.BallBrokenFloor;

class BallBrokenFloorTest {

	private static final int N_FLOORS = 100;

	@Test
	void ballBrokenFloorTest() {
		BallBrokenFloor bbf = new BallBrokenFloor(N_FLOORS);
		assertEquals(bbf.getBrokenFloor(), getMinBrokenFloor(bbf));
	}

	private int getMinBrokenFloor(BallBrokenFloor bbf) {
		    int left = 1;
		    int right = N_FLOORS;

		    while (left <= right) {
		        //int middle = left/2 + right/2; 
		        int middle = (left+right)>>>1; 

		        try {
		            bbf.checkFloor(middle);
		            left = middle + 1; 
		        } catch (Exception e) {
		            right = middle - 1; 
		        }
		    }

		    return left; 
	}

}
