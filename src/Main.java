import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		String separator = "----------------------------------------------------";
		System.out.println(separator);
		System.out.println("ArrayList Filter");
		System.out.println(separator);
		list();
		System.out.println(separator);
		System.out.println("MapTest Join Query");
		System.out.println(separator);
		MapTest();
		System.out.println(separator);
		System.out.println("Media ");
		System.out.println(separator);
		GenericLibrary<Media> library = new GenericLibrary<Media>();
		library.addMedia(new Book("The Lord of the Rings"));
		library.addMedia(new Video("ferris bueller's day off"));
		library.addMedia(new Book("The Fellowship of the Ring"));
		library.printMedia();
		System.out.println("");
		System.out.println(separator);
		System.out.println("Getting video by name");
		Media result = library.getMediaByTitle("ferris bueller's day off");
		if (result != null) {
			System.out.println("Retrieved " + result.getName() + " Format: " + result.getClass().getSimpleName());
		} else {
			System.out.println("No video found");
		}
		System.out.println("Getting video by index");
		result = library.getMediaByIndex(2);
		if (result != null) {
			System.out.println("Retrieved " + result.getName() + " Format: " + result.getClass().getSimpleName());
		} else {
			System.out.println("No video found");
		}
	}

	// Print list of values filtered
	private static void list() {
		ArrayList<Integer> list = new
				ArrayList<Integer>(Arrays.asList(1, 2, 3, -2, 5, -10));
		// filter list for 2 and negative numbers
		list.stream().filter(i -> (i > 0 & i != 2)).forEach(item -> System.out.print(item + " "));
		System.out.println("");
	}

	// query two maps for similar values {key:value}
	private static void MapTest() {
		Map<String, String> accountsMap = new HashMap<String, String>();
		accountsMap.put("E123", "Charles");
		accountsMap.put("E156", "Heiko");
		accountsMap.put("E542", "Brendan");
		accountsMap.put("E174", "Tobin");
		Map<String, String> quotaMap = new HashMap<String, String>();

		quotaMap.put("Charles", "5MB");
		quotaMap.put("Heiko", "50MB");
		quotaMap.put("Tobin", "4MB");
		quotaMap.put("Bruce", "8MB");

		//foreach key value
		accountsMap.forEach((k, v) -> {
			if (quotaMap.containsKey(v)) {
				System.out.println(k + " " + v + " " + quotaMap.get(v));
			} else {
				System.out.println(k + " no quote yet");
			}
		});
	}

	public static class GenericLibrary<E extends Media> {
		private final ArrayList<E> mediaList = new ArrayList<E>();

		public void addMedia(E media) {
			mediaList.add(media);
		}

		@Override
		public String toString() {
			return "GenericLibrary{" +
					"mediaList=" + mediaList +
					'}';
		}

		public void printMedia() {
			for (E media : mediaList) {
				System.out.println(media.getClass() + " " + media.getName());
			}
		}

		// Get media by title
		public Media getMediaByTitle(String title) {
			for (E media : mediaList) {
				if (media.getName().equals(title)) {
					return media;
				}
			}
			return null;
		}

		// Get media by index
		public Media getMediaByIndex(int index) {
			if (index < mediaList.size()) {
				return mediaList.get(index);
			} else {
				return null;
			}
		}
	}
}
