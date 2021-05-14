package render;

import java.util.ArrayList;

public class Animation {

	private ArrayList<Model> frames;
	private int delay;
	
	private int currentFrame;
	private int currentDelay;
	
	public Animation(int delay, Model... framesModels) {
		this.frames = new ArrayList<Model>();
		this.delay = delay;
		this.currentFrame = 0;
		this.currentDelay = 0;
		
		for(Model model : framesModels) {
			this.frames.add(model);
		}
	}
	
	public Model getCurrentFrame() {
		this.currentDelay++;
		if(this.currentDelay == this.delay) {
			this.currentFrame++;
			if(this.currentFrame == frames.size()) {
				this.currentFrame = 0;
			}
			this.currentDelay = 0;
		}
		return frames.get(currentFrame);
	}	
}