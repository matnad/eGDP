package uebungen.blatt11.boids;
import java.util.Vector;

/*
 * Limit the speed of a boid by excerting a -factor*velocity force
 */
public class BoidRuleLimitedSpeed extends BoidRule {

	private double factor;
	
	BoidRuleLimitedSpeed(double factor) {
		this.factor = factor;
	}
	
	@Override
	public Vector2 getUpdate(Boid boid, Vector<Boid> neighbours) {
		return boid.getVelocity().multiply(-factor*boid.getVelocity().normL2());
	}


}
