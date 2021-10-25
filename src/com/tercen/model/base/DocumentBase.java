package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class DocumentBase extends PersistentObject {

	public String description;
	public String name;
	public String createdBy;
	public Acl acl;
	public Date createdDate;
	public Date lastModifiedDate;
	public ArrayList<Url> urls;
	public ArrayList<String> tags;
	public ArrayList<Pair> meta;
	public Url url;
	public String version;
	public ArrayList<String> authors;
	public boolean isPublic;

	public DocumentBase() {
		super();
		this.description = "";
		this.name = "";
		this.createdBy = "";
		this.tags = new ArrayList<String>();
		this.version = "";
		this.authors = new ArrayList<String>();
		this.isPublic = true;
		this.acl = new Acl();
		this.createdDate = new Date();
		this.lastModifiedDate = new Date();
		this.urls = new ArrayList<Url>();
		this.meta = new ArrayList<Pair>();
		this.url = new Url();
	}

	public DocumentBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Document_CLASS ? m.get(Vocabulary.KIND) : null);
		this.description = (String) m.get(Vocabulary.description_DP);
		this.name = (String) m.get(Vocabulary.name_DP);
		this.createdBy = (String) m.get(Vocabulary.createdBy_DP);
		if (m.get(Vocabulary.tags_DP) == null)
			this.tags = new ArrayList<String>();
		else
			this.tags = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.tags_DP)));
		this.version = (String) m.get(Vocabulary.version_DP);
		if (m.get(Vocabulary.authors_DP) == null)
			this.authors = new ArrayList<String>();
		else
			this.authors = new ArrayList<String>((Collection<? extends String>) (m.get(Vocabulary.authors_DP)));
		this.isPublic = (boolean) m.get(Vocabulary.isPublic_DP);
		if (m.get(Vocabulary.acl_OP) == null)
			this.acl = new Acl();
		else
			this.acl = AclBase.fromJson((LinkedHashMap) m.get(Vocabulary.acl_OP));
		if (m.get(Vocabulary.createdDate_OP) == null)
			this.createdDate = new Date();
		else
			this.createdDate = DateBase.fromJson((LinkedHashMap) m.get(Vocabulary.createdDate_OP));
		if (m.get(Vocabulary.lastModifiedDate_OP) == null)
			this.lastModifiedDate = new Date();
		else
			this.lastModifiedDate = DateBase.fromJson((LinkedHashMap) m.get(Vocabulary.lastModifiedDate_OP));
		if (m.get(Vocabulary.urls_OP) == null)
			this.urls = new ArrayList<Url>();
		else {
			this.urls = new ArrayList<Url>();
			ArrayList list = (ArrayList) m.get(Vocabulary.urls_OP);
			for (Object map : list) {
				this.urls.add(UrlBase.createFromJson((LinkedHashMap) map));
			}
		}
		if (m.get(Vocabulary.meta_OP) == null)
			this.meta = new ArrayList<Pair>();
		else {
			this.meta = new ArrayList<Pair>();
			ArrayList list = (ArrayList) m.get(Vocabulary.meta_OP);
			for (Object map : list) {
				this.meta.add(PairBase.createFromJson((LinkedHashMap) map));
			}
		}
		if (m.get(Vocabulary.url_OP) == null)
			this.url = new Url();
		else
			this.url = UrlBase.fromJson((LinkedHashMap) m.get(Vocabulary.url_OP));
	}

	public static Document createFromJson(LinkedHashMap m) {
		return DocumentBase.fromJson(m);
	}

	public static Document fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Document_CLASS:
			return new Document(m);
		case Vocabulary.Team_CLASS:
			return new Team(m);
		case Vocabulary.RSourceLibrary_CLASS:
			return new RSourceLibrary(m);
		case Vocabulary.RenvInstalledLibrary_CLASS:
			return new RenvInstalledLibrary(m);
		case Vocabulary.ShinyOperator_CLASS:
			return new ShinyOperator(m);
		case Vocabulary.DockerWebAppOperator_CLASS:
			return new DockerWebAppOperator(m);
		case Vocabulary.DockerOperator_CLASS:
			return new DockerOperator(m);
		case Vocabulary.ROperator_CLASS:
			return new ROperator(m);
		case Vocabulary.WebAppOperator_CLASS:
			return new WebAppOperator(m);
		case Vocabulary.GitOperator_CLASS:
			return new GitOperator(m);
		case Vocabulary.CubeQueryTableSchema_CLASS:
			return new CubeQueryTableSchema(m);
		case Vocabulary.TableSchema_CLASS:
			return new TableSchema(m);
		case Vocabulary.ComputedTableSchema_CLASS:
			return new ComputedTableSchema(m);
		case Vocabulary.Issue_CLASS:
			return new Issue(m);
		case Vocabulary.FileDocument_CLASS:
			return new FileDocument(m);
		case Vocabulary.FolderDocument_CLASS:
			return new FolderDocument(m);
		case Vocabulary.Schema_CLASS:
			return new Schema(m);
		case Vocabulary.IssueMessage_CLASS:
			return new IssueMessage(m);
		case Vocabulary.Workflow_CLASS:
			return new Workflow(m);
		case Vocabulary.User_CLASS:
			return new User(m);
		case Vocabulary.RLibrary_CLASS:
			return new RLibrary(m);
		case Vocabulary.Operator_CLASS:
			return new Operator(m);
		case Vocabulary.WorkerEndpoint_CLASS:
			return new WorkerEndpoint(m);
		case Vocabulary.ProjectDocument_CLASS:
			return new ProjectDocument(m);
		case Vocabulary.Project_CLASS:
			return new Project(m);
		case Vocabulary.SubscriptionPlan_CLASS:
			return new SubscriptionPlan(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Document in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Document_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Document_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.description_DP, description);
		m.put(Vocabulary.name_DP, name);
		m.put(Vocabulary.createdBy_DP, createdBy);
		m.put(Vocabulary.acl_OP, acl == null ? null : acl.toJson());
		m.put(Vocabulary.createdDate_OP, createdDate == null ? null : createdDate.toJson());
		m.put(Vocabulary.lastModifiedDate_OP, lastModifiedDate == null ? null : lastModifiedDate.toJson());
		m.put(Vocabulary.urls_OP, BaseObject.objectListToJson(urls));
		m.put(Vocabulary.tags_DP, tags);
		m.put(Vocabulary.meta_OP, BaseObject.objectListToJson(meta));
		m.put(Vocabulary.url_OP, url == null ? null : url.toJson());
		m.put(Vocabulary.version_DP, version);
		m.put(Vocabulary.authors_DP, authors);
		m.put(Vocabulary.isPublic_DP, isPublic);
		return m;
	}
}