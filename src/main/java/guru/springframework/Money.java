package guru.springframework;

public class Money implements Expression {
	protected int amount;
	protected String currency;

	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}

	public Money times(int multiplier) {
        return new Money(amount * multiplier, this.currency);
    }
	
	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}

	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}
	
    public String currency() {
        return currency;
	}
	
	public Expression plus(Money addend) {
		return new Money(amount + addend.amount, currency);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;		
		Money other = (Money) obj;
		if (amount != other.amount)
			return false;
		if (currency != other.currency)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("Money{amount=%d, currency='%s'}", amount, currency);
	}
}
