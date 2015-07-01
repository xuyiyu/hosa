package com.mexp.web.utils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Random;

public class LotteryUtils {

	/**
	 * 计算概率
	 * 
	 * @param totalNumber		参与总人数
	 * @param hasBeenNumber		已经抽奖人数
	 * @param winningNumber		奖项数量
	 * @return
	 */
	public static Double calculateProbability(Long totalNumber,
			Long hasBeenNumber, Long winningNumber) {
		return winningNumber / ((totalNumber - hasBeenNumber) * 1.0);
	}

	/**
	 * 
	 * @param awardsList
	 * @return
	 */
	public static Awards lottery(List<Awards> awardsList) {
		
		Random random = new Random();
		
		double average = 1.0 / awardsList.size();

		List<Double> probabilities = new ArrayList<Double>();
		Deque<Integer> smallProbability = new ArrayDeque<Integer>();
		Deque<Integer> largeProbability = new ArrayDeque<Integer>();

		double probabilityWinning = 0D;
		for (int i = 0; i < awardsList.size(); i++) {

			Awards awards = awardsList.get(i);
			double awardsProbability = awards.getProbability();
			probabilities.add(awardsProbability);
			if (awardsProbability >= average) {
				largeProbability.add(i);
			} else {
				smallProbability.add(i);
			}
			
			probabilityWinning += awardsProbability;
		}
		
		if(probabilityWinning < 1) {
			probabilities.add(1 - probabilityWinning);
			largeProbability.add(probabilities.size() - 1);
		}
		
		int[] alias = new int[probabilities.size()];
		double[] probability = new double[probabilities.size()];
		
		while (!smallProbability.isEmpty() && !largeProbability.isEmpty()) {
			int less = smallProbability.removeLast();
			int more = largeProbability.removeLast();

			probability[less] = probabilities.get(less) * probabilities.size();
			alias[less] = more;

			probabilities.set(more,
					(probabilities.get(more) + probabilities.get(less))
							- average);

			if (probabilities.get(more) >= 1.0 / probabilities.size()) {
				largeProbability.add(more);
			} else {
				smallProbability.add(more);
			}
		}

		while (!smallProbability.isEmpty()) {
			probability[smallProbability.removeLast()] = 1.0;
		}

		while (!largeProbability.isEmpty()) {
			probability[largeProbability.removeLast()] = 1.0;
		}

		int column = random.nextInt(probability.length);

		boolean coinToss = random.nextDouble() < probability[column];

		int index = coinToss ? column : alias[column];

		return (index >= awardsList.size()?new Awards():awardsList.get(index));

	}
	
	public static void main(String args[]) {
		List<Awards> awardsList = new ArrayList<Awards>();
		Awards one = new Awards();
		one.setId(1L);
		one.setName("1");
		one.setProbability(0.01);
		awardsList.add(one);
		
		Awards two = new Awards();
		two.setId(2L);
		two.setName("2");
		two.setProbability(0.05);
		awardsList.add(two);
		for(int i=0; i< 50;i++) {
			Awards awards = LotteryUtils.lottery(awardsList);
			System.out.println(awards.getName());
			if(awards.getId() > 0) {
				return;
			}
		}
		
	}
}
