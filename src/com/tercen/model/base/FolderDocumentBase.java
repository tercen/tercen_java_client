package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class FolderDocumentBase extends ProjectDocument {

	public FolderDocumentBase() {
		super();
	}

	public FolderDocumentBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.FolderDocument_CLASS ? m.get(Vocabulary.KIND) : null);
	}

	public static FolderDocument createFromJson(LinkedHashMap m) {
		return FolderDocumentBase.fromJson(m);
	}

	public static FolderDocument fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.FolderDocument_CLASS:
			return new FolderDocument(m);
		default:
			throw new IllegalArgumentException(
					"bad kind : " + kind + " for class FolderDocument in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.FolderDocument_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.FolderDocument_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		return m;
	}
}