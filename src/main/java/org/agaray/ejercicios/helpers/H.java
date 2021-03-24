package org.agaray.ejercicios.helpers;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class H {
	public String resaltar(String texto) {
		return "<h4>" + texto + "</h4>";
	}

	public String pintarRadio(String name, Map<String, String> arrayValueLabel, String seleccionado) {
		String html = "";
		String ck = "checked=\"checked\"";
		for (String k : arrayValueLabel.keySet()) {
			String ckHTML = (k.equals(seleccionado) ? ck : "");
			html += "<input type=\"radio\" name=\""+name+"\" value=\""+k+"\" id=\"id-"+k+"\" "+ckHTML+">\n"
					+ "<label for=\"id-"+k+"\">"+arrayValueLabel.get(k)+"</label><br />\n\n";
		}

		return html;
	}

}
