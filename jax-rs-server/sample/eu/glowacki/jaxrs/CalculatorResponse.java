package eu.glowacki.jaxrs;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CalculatorResponse {

	private int _result;

	public int getResult() {
		return _result;
	}

	public void setResult(int result) {
		_result = result;
	}
}