package ex2016.a01.t2.e1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VectorImpl<X> implements Vector<X> {
	private List<X> list = new ArrayList<X>();

	public VectorImpl(List<X> list) {
		this.list.addAll(list);
	}
	
	@Override
	public Optional<X> getAtPosition(int position) {
		if (position > list.size() - 1) {
			return Optional.empty();
		}
		
		var element = list.get(position);
		return Optional.of(element);
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public List<X> asList() {
		return List.copyOf(list);
	}

	@Override
	public void executeOnAllElements(Executor<X> executor) {
		list.forEach(executor::execute);
	}

}
