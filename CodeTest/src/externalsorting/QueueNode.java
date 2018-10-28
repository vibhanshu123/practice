package externalsorting;


public class QueueNode implements Comparable<QueueNode>{
		public int array;
		public int index;
		public int value;
		
		
		public QueueNode(int array, int index, int value) {
			this.array = array;
			this.index = index;
			this.value = value;
		}

		@Override
		public int compareTo(QueueNode o) {
			if(value<o.value) return -1;
			if(value>o.value) return 1;
			return 0;
		}
		
	}	
	