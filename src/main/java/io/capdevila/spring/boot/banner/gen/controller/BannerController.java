package io.capdevila.spring.boot.banner.gen.controller;

import io.capdevila.spring.boot.banner.gen.banner.Banner;
import io.capdevila.spring.boot.banner.gen.banner.BannerGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/banner")
public class BannerController {

	private BannerGenerator bannerGenerator;

	public BannerController(BannerGenerator bannerGenerator) {
		this.bannerGenerator = bannerGenerator;
	}

	@RequestMapping(value = "/generate", method = RequestMethod.POST)
	public String generateBanner(@RequestParam("image") MultipartFile image, @RequestParam(value = "dark", defaultValue = "false") boolean dark,
			@RequestParam(value = "ansi", defaultValue = "true") boolean ansi) {
		log.info("image content-type: {}", image.getContentType());
		log.info("dark: {}", dark);
		log.info("ansi: {}", ansi);
		Banner banner = bannerGenerator.generateBanner(image, dark);
		if (ansi) {
			return banner.getAnsi();
		}
		return banner.getHtml();
	}
}
