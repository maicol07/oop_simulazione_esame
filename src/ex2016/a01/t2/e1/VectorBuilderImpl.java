package ex2016.a01.t2.e1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class VectorBuilderImpl<X> implements VectorBuilder<X> {
	private List<X> list = new ArrayList<X>();
	private boolean buildDone = false;
	
	@Override
	public void addElement(X x) {
		list.add(x);
	}

	@Override
	public void removeElement(int position) {
		list.remove(position);
	}

	@Override
	public void reverse() {
		Collections.reverse(list);
	}

	@Override
	public void clear() {
		list.clear();
	}

	@Override
	public Optional<Vector<X>> build() {
		Optional<Vector<X>> value = buildDone ? Optional.empty() : Optional.of(new VectorImpl<X>(list));
		buildDone = true;
		return value;
	}

	@Override
	public Optional<Vector<X>> buildWithFilter(Filter<X> filter) {
		var list = this.list.stream().filter(filter::check).collect(Collectors.toList());
		
		// All elements must pass the filter
		if (list.size() != this.list.size()) {
			return Optional.empty();
		}
		
		Optional<Vector<X>> value = buildDone ? Optional.empty() : Optional.of(new VectorImpl<X>(list));
		buildDone = true;
		return value;
	}

	@Override
	public <Y> VectorBuilder<Y> mapToNewBuilder(Mapper<X, Y> mapper) {
		var builder = new VectorBuilderImpl<Y>();
		list.forEach(element -> builder.addElement(mapper.transform(element)));
		return builder;
	}

}
