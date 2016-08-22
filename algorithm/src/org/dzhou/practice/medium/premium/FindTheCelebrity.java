package org.dzhou.practice.medium.premium;

/**
 * 277. Find the Celebrity
 * 
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among
 * them, there may exist one celebrity. The definition of a celebrity is that
 * all the other n - 1 people know him/her but he/she does not know any of them.
 * 
 * Now you want to find out who the celebrity is or verify that there is not
 * one. The only thing you are allowed to do is to ask questions like:
 * "Hi, A. Do you know B?" to get information of whether A knows B. You need to
 * find out the celebrity (or verify there is not one) by asking as few
 * questions as possible (in the asymptotic sense).
 * 
 * You are given a helper function bool knows(a, b) which tells you whether A
 * knows B. Implement a function int findCelebrity(n), your function should
 * minimize the number of calls to knows.
 * 
 * Note: There will be exactly one celebrity if he/she is in the party. Return
 * the celebrity's label if there is a celebrity in the party. If there is no
 * celebrity, return -1.
 * 
 * @author zhoudong
 *
 */
public class FindTheCelebrity {

	class Relation {
		boolean knows(int a, int b) {
			return true;
		};
	}

	// The knows API is defined in the parent class Relation.
	public class Solution extends Relation {

		public int findCelebrity(int n) {
			for (int i = 0; i < n - 1; i++) {
				if (knows(i, i + 1))
					continue;
				if (isCelebrity(n, i))
					return i;
			}
			return isCelebrity(n, n - 1) ? (n - 1) : -1;
		}

		private boolean isCelebrity(int n, int target) {
			return allPeopleKnow(n, target) && dontKnowAnyone(n, target);
		}

		private boolean allPeopleKnow(int n, int target) {
			for (int i = 0; i < n; i++) {
				if (i == target)
					continue;
				if (!knows(i, target))
					return false;
			}
			return true;
		}

		private boolean dontKnowAnyone(int n, int target) {
			for (int i = 0; i < n; i++) {
				if (i == target)
					continue;
				if (knows(target, i))
					return false;
			}
			return true;
		}
	}

}
