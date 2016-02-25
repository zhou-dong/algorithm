package org.dzhou.interview.moderate;

/**
 * Practice of "cracking the code interview"
 * 
 * @author DONG ZHOU
 *
 *         我们现在有四个槽，每个槽放一个球，颜色可能是红色(R)、黄色(Y)、绿色(G)或蓝色(B)。
 *         例如，可能的情况为RGGB(槽1为红色，槽2、3为绿色，槽4为蓝色)，作为玩家，你需要试图猜出颜色的组合。
 *         比如，你可能猜YRGB。要是你猜对了某个槽的颜色，则算一次“猜中”。
 *         要是只是猜对了颜色但槽位猜错了，则算一次“伪猜中”。注意，“猜中”不能算入“伪猜中”。
 * 
 *         给定两个string A和guess。分别表示颜色组合，和一个猜测。
 *         请返回一个int数组，第一个元素为猜中的次数，第二个元素为伪猜中的次数。
 * 
 *         测试样例： "RGBY","GGRR" 返回：[1,1]
 */
public class MasterMind {

	public class Result {
		public int hits = 0;
		public int pseudoHits = 0;
	}

	public enum Color {

		RED(0), YELLOW(1), GREEN(2), BLUE(3);

		int index;

		private Color(int index) {
			this.index = index;
		}

	}

	public Result estimate(Color[] guess, Color[] solution) {
		if (guess.length != solution.length)
			return null;

		Result result = new Result();
		int[] frequencies = new int[Color.values().length];

		// 计算猜中的次数，构造频率表
		for (int i = 0; i < guess.length; i++) {
			if (guess[i] == solution[i])
				result.hits++;
			else
				frequencies[solution[i].index]++;
		}

		// 计算伪猜中
		for (int i = 0; i < guess.length; i++) {
			int code = guess[i].index;
			if (guess[i] == solution[i] || frequencies[code] <= 0) {
				continue;
			}
			result.pseudoHits++;
			frequencies[code]--;
		}

		return result;
	}

}
