package com.crm.comcast.generic;

import java.util.Random;
/**
 * 
 * @author chaithanya
 *
 */

public class JavaUtility 
{
	/**
	 * 
	 * @param range
	 * @return random number
	 */
	public int getRandomNum(int range)
	{
		Random random = new Random();
		int randomnum = random.nextInt(range);
		return randomnum;
	}

}
