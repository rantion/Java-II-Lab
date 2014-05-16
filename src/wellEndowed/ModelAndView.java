package wellEndowed;

public class ModelAndView {
	private String viewName;
	private Object model;
	
	public ModelAndView(Object model, String viewName){
		this.model = model;
		this.viewName = viewName;
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public Object getModel() {
		return model;
	}

	public void setModel(Object model) {
		this.model = model;
	}

}
