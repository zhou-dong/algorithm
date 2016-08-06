package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent tweets in
 * the user's news feed. Your design should support the following methods:
 * 
 * postTweet(userId, tweetId): Compose a new tweet. getNewsFeed(userId):
 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
 * the news feed must be posted by users who the user followed or by the user
 * herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee. Example:
 * 
 * Twitter twitter = new Twitter();
 * 
 * // User 1 posts a new tweet (id = 5).<br>
 * twitter.postTweet(1, 5);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5].<br>
 * twitter.getNewsFeed(1);
 * 
 * // User 1 follows user 2.<br>
 * twitter.follow(1, 2);
 * 
 * // User 2 posts a new tweet (id = 6).<br>
 * twitter.postTweet(2, 6);
 * 
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5].<br>
 * // Tweet id 6 should precede tweet id 5 because it is posted after tweet id
 * 5.<br>
 * twitter.getNewsFeed(1);
 * 
 * // User 1 unfollows user 2.<br>
 * twitter.unfollow(1, 2);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5],<br>
 * // since user 1 is no longer following user 2.<br>
 * twitter.getNewsFeed(1);
 * 
 * @author zhoudong
 *
 */
public class DesignTwitter {

	public class Twitter {

		private List<Integer> tweets;
		private Map<Integer, List<Integer>> userTweets;
		private Map<Integer, Integer> tweetOwner;
		private Map<Integer, Set<Integer>> userRelation;

		/** Initialize your data structure here. */
		public Twitter() {
			tweets = new ArrayList<>();
			userTweets = new HashMap<>();
			tweetOwner = new HashMap<>();
			userRelation = new HashMap<>();
		}

		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			if (!userTweets.containsKey(userId))
				userTweets.put(userId, new ArrayList<>());
			userTweets.get(userId).add(tweetId);
			tweetOwner.put(tweetId, userId);
			tweets.add(tweetId);
		}

		/**
		 * Retrieve the 10 most recent tweet ids in the user's news feed. Each
		 * item in the news feed must be posted by users who the user followed
		 * or by the user herself. Tweets must be ordered from most recent to
		 * least recent.
		 */
		public List<Integer> getNewsFeed(int userId) {
			int resultSize = 10;
			List<Integer> result = new ArrayList<>(resultSize);
			Set<Integer> followees = getFollowees(userId);
			int count = 0;
			for (int i = tweets.size() - 1; i >= 0; i--) {
				if (count == resultSize)
					break;
				int tweet = tweets.get(i);
				int owner = tweetOwner.get(tweet);
				if (owner == userId || followees.contains(owner)) {
					result.add(tweet);
					count++;
				}
			}
			return result;
		}

		private Set<Integer> getFollowees(int userId) {
			return userRelation.containsKey(userId) ? userRelation.get(userId) : Collections.emptySet();
		}

		/**
		 * Follower follows a followee. If the operation is invalid, it should
		 * be a no-op.
		 */
		public void follow(int followerId, int followeeId) {
			if (!userRelation.containsKey(followerId))
				userRelation.put(followerId, new HashSet<>());
			userRelation.get(followerId).add(followeeId);
		}

		/**
		 * Follower unfollows a followee. If the operation is invalid, it should
		 * be a no-op.
		 */
		public void unfollow(int followerId, int followeeId) {
			if (userRelation.containsKey(followerId)) {
				userRelation.get(followerId).remove(followeeId);
			}
		}

	}

	/**
	 * Your Twitter object will be instantiated and called as such:<br>
	 * Twitter obj = new Twitter(); <br>
	 * obj.postTweet(userId,tweetId); <br>
	 * List<Integer> param_2 = obj.getNewsFeed(userId); <br>
	 * obj.follow(followerId,followeeId); <br>
	 * obj.unfollow(followerId,followeeId);
	 */
}
