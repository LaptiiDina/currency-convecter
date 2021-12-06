package telran.dto.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class ChangeMoneyApp {

	private static final Object ACCESS_KEY = "5b1be98592e5e968cb7868aaabad68cf";

	public static void main(String[] args) throws URISyntaxException, IOException {
		RestTemplate restTemplate = new RestTemplate();
		RequestEntity<String> requestEntity = new RequestEntity<String>(HttpMethod.GET,
				new URI("http://data.fixer.io/api/latest?access_key=5b1be98592e5e968cb7868aaabad68cf"));

		// String url = "http://data.fixer.io/api/latest";

//UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
//.queryParam("access key", ACCESS_KEY)
//.queryParam("symbols", "usd,eur,uah,rub");
//		
//RequestEntity<String> requestEntity = new RequestEntity<String>(HttpMethod.GET,builder.build().toUri());

		ResponseEntity<Dto> responseEntity = restTemplate.exchange(requestEntity,
				new ParameterizedTypeReference<Dto>() {
				});

		HashMap<String, Double> map = new HashMap<String, Double>();
		map = responseEntity.getBody().getRates();

		System.out.println("Enter currency from");
		String fromCurrency;
		String toCarrency;
		double quantity;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			fromCurrency = reader.readLine().trim().toUpperCase();
			System.out.println("Enter currency to");
			toCarrency = reader.readLine().trim().toUpperCase();
			System.out.println("Enter quantity");

			quantity = Double.parseDouble(reader.readLine());
		}
		double res = quantity / map.get(fromCurrency) * map.get(toCarrency);
		System.out.println(res);
	}

}
