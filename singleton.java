

calss Test {

private Test instance;

public getInstance() {

if(instance == null) {

	synchronised(this) {
		if(instance==null) {
			instance = new Test();
		}
	}

}
return instance;

private Test() {
}

clone() {

}
