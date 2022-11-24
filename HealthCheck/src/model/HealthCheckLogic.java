package model;

public class HealthCheckLogic {
public void healthCheck(HealthBeans healthBeans) {
	//Beansにセットするからインスタンス化
//	HealthBeans healthBeans = new HealthBeans();

	//BMIを算出してセット
	double height=healthBeans.getHeight();
	double weight = healthBeans.getWeight();

	double bmi = weight/ (height/100.0 * height /100.0);
	healthBeans.setBmi(bmi);

	//BMI指数から体型を判定してセット
	String bodyType;
	if(bmi<18.5) {
		bodyType ="痩せ型";
	}else if(bmi < 25) {
		bodyType ="普通";
	}else {
		bodyType ="肥満";
	}
	healthBeans.setBodyType(bodyType);

}
}
