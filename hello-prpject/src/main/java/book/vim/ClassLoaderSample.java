package book.vim;

import java.io.IOException;
import java.io.InputStream;

/**
 * 比较两个类是否“相等”，只有在两个类是由同一个类加载器加载的前提下才有意义。
 * @author i324779
 *
 */
public class ClassLoaderSample {

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ClassLoader myClassLoader = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) {

				try {
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
					InputStream is = this.getClass().getResourceAsStream(fileName);
					if (null == is) {
						return super.loadClass(name);
					}
					byte[] b;

					b = new byte[is.available()];
					is.read(b);

					return this.defineClass(name, b, 0, b.length);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				return null;
			}
		};

		Object obj = myClassLoader.loadClass("book.vim.ClassLoaderSample").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof book.vim.ClassLoaderSample);
	}

}
