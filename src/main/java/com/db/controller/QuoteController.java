package com.db.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.db.model.Quote;
import com.db.model.Quotes;
import com.db.rep.QuoteRep;

@RestController
@RequestMapping("/me")
public class QuoteController {
	
	@Autowired
	private QuoteRep rep;
	
	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") String username) {

		return getQuotesByUserName(username);

	}

	
	
	
	@PostMapping("/add")
	public List<String> addQuote(@RequestBody final Quotes quotes)
	{	
		quotes.getQuotes()
		.stream()
		.forEach(quote->{
			rep.save(new Quote(quotes.getUsername(),quote));
		});
	return getQuotesByUserName(quotes.getUsername());
	}
	
	
	private List<String> getQuotesByUserName(@PathVariable("username") String username)
	{
		
	 return rep.findByUserName(username)
			 .stream()
			 .map(Quote::getQuote)
			 .collect(Collectors.toList());
				
	}
	
	@DeleteMapping("/delete/{username}")
	public List<String> deleteByUserName(@PathVariable("username") String username)
	{
		List<Quote> quotes=rep.findByUserName(username);
		rep.deleteAll(quotes);
		
		return getQuotesByUserName(username) ;
		
	}

}
