package org.dzhou.practice.easy;

/**
 * 
 * @author zhoudong
 *
 */
public class BullsAndCows {

	public String getHint(String secret, String guess) {

		if (secret == null || guess == null || secret.length() != guess.length()) {
			return "";
		}

		int countA = 0, countB = 0;
		int[] count = new int[10];

		for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				countA++;
			} else {
				count[secret.charAt(i) - '0']++;
				if (count[secret.charAt(i) - '0'] <= 0) {
					countB++;
				}
				count[guess.charAt(i) - '0']--;
				if (count[guess.charAt(i) - '0'] >= 0) {
					countB++;
				}
			}
		}

		return countA + "A" + countB + "B";
	}

}
