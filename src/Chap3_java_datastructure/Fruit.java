package Chap3_java_datastructure;

public class Fruit implements Comparable<Fruit> {
	//comparable의 객체타입에 <Fruit>가 들어가는 이유:  Fruit 객체와 또 다른 Fruit 객체를 비교하기 위해
	    private String name;
	    private int price;
	    public Fruit(String name, int price) {
	        this.name = name;
	        this.price = price;
	    }
	    
	    public String getName() {
			return name;
		}

		public int getPrice() {
			return price;
		}

	    @Override
	    public String toString() {
	        return "<" + name + ", " + price + ">";
	    }

		@Override
//		public int compareTo(Fruit o) {
//			if (this.price < o.price) return -1;
//			else if (this.price > o.price) return 1;
//			else return this.name.compareTo(o.name);
//		}
		public int compareTo(Fruit o) {
			if (this.name.compareTo(o.name)<0) {
				return -1;
			}
			else if (this.name.compareTo(o.name)>0) {
				return 1;
			}
			else 
			{
				if (this.price < o.price) {
					return -1;
				}
				else if (this.price > o.price) {
					return 1;
				}
				else return 0;
			}
		}		
}

