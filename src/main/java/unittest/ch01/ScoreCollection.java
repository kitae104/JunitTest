package unittest.ch01;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection
{
	private List<Scoreable> scores = new ArrayList<>();		// Scoreable 인터페이스를 구현한 클래스의 인스턴스를 저장하는 리스트
	
	public void add(Scoreable scoreable) {					// Scoreable 인터페이스를 구현한 클래스의 인스턴스를 저장하는 리스트에 인스턴스를 추가하는 메서드
		scores.add(scoreable);
	}
	
	public int arithmeticMean() {							// 산술 평균 계산
		int total = scores.stream().mapToInt(Scoreable::getScore).sum();
		return total / scores.size();
	}
}
