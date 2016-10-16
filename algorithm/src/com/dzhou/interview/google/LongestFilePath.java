package com.dzhou.interview.google;

/**
 * You are given a listing of directories and files in a file system. Each
 * directory and file has a name, which is a non-empty string consisting of
 * alphanumerical characters. Additionally, the name of each file contains a
 * single dot character; the part of the name starting with the dot is called
 * the extension. Directory names do not contain any dots. All the names are
 * case-sensitive.
 * 
 * Each entry is listed on a separate line. Every directory is followed by the
 * listing of its contents indented by one space character. The contents of the
 * root directory are not indented.
 * 
 * Here is a sample listing:
 * 
 * dir1 <br>
 * -dir11 <br>
 * -dir12 <br>
 * --picture.jpeg <br>
 * -dir121 <br>
 * --file1.txt <br>
 * dir2 <br>
 * -file2.gif <br>
 * 
 * We have three files (picture.jpeg, file1.txt, and file2.gif) and six
 * directories (dir1, dir11, dir12, dir121, dir2 and the root directory).
 * Directory dir12 contains two files (picture.jpeg and file1.txt) and an empty
 * directory (dir121). The root directory contains two directories (dir1 and
 * dir2).
 * 
 * The absolute path of a file is a string containing the names of directories
 * which have to be traversed (from the root directory) to reach the file,
 * separated by slash characters. For example, the absolute path to the file
 * file1.txt is "/dir1/dir12/file1.txt". Note that there is no "drive letter",
 * such as "C:", and each absolute path starts with a slash.
 * 
 * We are interested in image files only; that is, files with extensions.jpeg,
 * .png or .gif (and only these extensions). We are looking for the total length
 * of all the absolute paths leading to the image files. For example, in the
 * file system described above there are two image
 * files:"/dir1/dir12/picture.jpge" and "/dir2/file2.gif". The total length of
 * the absolute paths to these files is 24 + 15 = 39.
 * 
 * Write a function:
 * 
 * class Solution { public int solution(String S); }
 * 
 * that, given a string S consisting of N characters which contain the listing
 * of a file system, returns the total of lengths (in characters) modulo
 * 1,000,000,0007 of all the absolute paths to the image files.
 * 
 * For example, given the sample listing showed above, the function should
 * return 39, as explained above. If there are no image files, the function
 * should return 0.
 * 
 * Assume that:
 * 
 * N is an integer within the range[1..3,000,000];
 * 
 * string S consists only of alphanumerical characters (a-z and/or A-Z and/or
 * 0-9), spaces, dots (.) and end-of-line characters;
 * 
 * string S is a correct listing of a file system contents.
 * 
 * Complexity:
 * 
 * expected worst-case time complexity is O(N);
 * 
 * expected worst-case space complexity is O(N) (not counting the storage
 * required for input arguments).
 * 
 * 
 * 第二题依然是 找image 文件的题， 这次换成了找最长的文件夹路径。 这个题我看过很多版本： 版本一： leetcode 原题：求到image
 * 文件的最长路径。 版本二： 我这次遇到的版本， 求到 包含image文件的 文件夹的最长路径。 leetcode 版本用stack存Integer，
 * 我们这里就不能存Integer了，要存String，然后每次不进要得到当前路径，还是知道它上一层的路径。解之。. 1point 3acres 璁哄潧
 * 版本三： 包含image 文件的所有文件夹的路径之和。 这里要注意一个corner case， 如果一个文件夹下包含了 n个image
 * 文件，我记得看过的面经里写的只算一次，所以我们要用一个set，把已经算过的路径加进去，每次判断就好。解之。
 * 
 * @author zhoudong
 *
 *
 *
 */
public class LongestFilePath {

	class Solution {

		public int solution(String s) {

		}

	}

}
