package firstproject.northwind.core.utilities.results;

public class SucccessDataResult<T> extends DataResult<T>{

	public SucccessDataResult(T data, String message) {
		super(data, true, message);
	}
	
	public SucccessDataResult(T data) {
		super(data, true);
	}
	
	public SucccessDataResult(String message) {
		super(null, true, message);
	}
	
	public SucccessDataResult() {
		super(null, true);
	}
}
