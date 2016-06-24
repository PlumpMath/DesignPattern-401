package StrategyMethod;

//策略接口,计算购车总金额
interface Strategy {
	int calPrice(int price, int num);
}

// 购买5辆及以下不打折
class Nodiscount implements Strategy {
	public int calPrice(int price, int num) {
		return price * num;
	}
}

// 购买6-10辆打9.5折
class Disount1 implements Strategy {
	public int calPrice(int price, int num) {
		return (int) (price * num * 0.95);
	}
}
// 补全,购买11-20辆打9折算法实现

// 补全,购买20辆以上打8.5折算法实现

// 上下文,根据不同策略来计算购车总金额
class Context {
	private Strategy strategy;

	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public int calPrice(int price, int num) {
		// 补全计算价格算法
		return strategy.calPrice(price, num);
	}
}

public class Main {

	// 每辆车单价10000
	public static void main(String[] args) {
		Strategy strategy;
		// 计算购买3辆总金额
		strategy = new Nodiscount();
		Context context = new Context(strategy);
		System.out.println("购买3辆总金额: " + context.calPrice(10000, 3));
		// 补全 计算12辆总金额
		strategy = new Disount1();
		context = new Context(strategy);
		System.out.println("购买3辆总金额: " + context.calPrice(10000, 12));
	}

}
