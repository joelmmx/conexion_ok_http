package conexion;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ConexionAzteca {
	final OkHttpClient client = new OkHttpClient();

	String run(String url) throws IOException {
		Request request = new Request.Builder().url(url).build();

		try (Response response = client.newCall(request).execute()) {
			return response.body().string();
		}
	}

	public static void main(String[] args) throws IOException {
		ConexionAzteca azteca = new ConexionAzteca();
		String response = azteca.run("http://dvcarlos1mx-eval-test.apigee.net/banca-digital/usuarios/v1/usuarios");
		System.out.println(response);
	}
}
