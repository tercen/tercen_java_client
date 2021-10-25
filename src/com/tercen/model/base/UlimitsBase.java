package com.tercen.model.base;

import com.tercen.base.*;
import com.tercen.model.impl.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Collection;

public class UlimitsBase extends BaseObject {

	public int core_file_size;
	public int data_seg_size;
	public int scheduling_priority;
	public int file_size;
	public int pending_signals;
	public int max_locked_memory;
	public int max_memory_size;
	public int open_files;
	public int pipe_size;
	public int message_queues;
	public int real_time_priority;
	public int stack_size;
	public int cpu_time;
	public int max_user_processes;
	public int virtual_memory;
	public int file_locks;

	public UlimitsBase() {
		super();
		this.core_file_size = 0;
		this.data_seg_size = 0;
		this.scheduling_priority = 0;
		this.file_size = 0;
		this.pending_signals = 0;
		this.max_locked_memory = 0;
		this.max_memory_size = 0;
		this.open_files = 0;
		this.pipe_size = 0;
		this.message_queues = 0;
		this.real_time_priority = 0;
		this.stack_size = 0;
		this.cpu_time = 0;
		this.max_user_processes = 0;
		this.virtual_memory = 0;
		this.file_locks = 0;
	}

	public UlimitsBase(LinkedHashMap m) {
		super(m);
		this.subKind = m.get(Vocabulary.SUBKIND) != null ? (String) m.get(Vocabulary.SUBKIND)
				: (String) (m.get(Vocabulary.KIND) != Vocabulary.Ulimits_CLASS ? m.get(Vocabulary.KIND) : null);
		this.core_file_size = (int) m.get(Vocabulary.core_file_size_DP);
		this.data_seg_size = (int) m.get(Vocabulary.data_seg_size_DP);
		this.scheduling_priority = (int) m.get(Vocabulary.scheduling_priority_DP);
		this.file_size = (int) m.get(Vocabulary.file_size_DP);
		this.pending_signals = (int) m.get(Vocabulary.pending_signals_DP);
		this.max_locked_memory = (int) m.get(Vocabulary.max_locked_memory_DP);
		this.max_memory_size = (int) m.get(Vocabulary.max_memory_size_DP);
		this.open_files = (int) m.get(Vocabulary.open_files_DP);
		this.pipe_size = (int) m.get(Vocabulary.pipe_size_DP);
		this.message_queues = (int) m.get(Vocabulary.message_queues_DP);
		this.real_time_priority = (int) m.get(Vocabulary.real_time_priority_DP);
		this.stack_size = (int) m.get(Vocabulary.stack_size_DP);
		this.cpu_time = (int) m.get(Vocabulary.cpu_time_DP);
		this.max_user_processes = (int) m.get(Vocabulary.max_user_processes_DP);
		this.virtual_memory = (int) m.get(Vocabulary.virtual_memory_DP);
		this.file_locks = (int) m.get(Vocabulary.file_locks_DP);
	}

	public static Ulimits createFromJson(LinkedHashMap m) {
		return UlimitsBase.fromJson(m);
	}

	public static Ulimits fromJson(LinkedHashMap m) {
		String kind = (String) m.get(Vocabulary.KIND);
		switch (kind) {
		case Vocabulary.Ulimits_CLASS:
			return new Ulimits(m);
		default:
			throw new IllegalArgumentException("bad kind : " + kind + " for class Ulimits in fromJson constructor");
		}
	}

	public LinkedHashMap toJson() {
		LinkedHashMap m = super.toJson();
		m.put(Vocabulary.KIND, Vocabulary.Ulimits_CLASS);
		if (this.subKind != null && this.subKind != Vocabulary.Ulimits_CLASS)
			m.put(Vocabulary.SUBKIND, this.subKind);
		else
			m.remove(Vocabulary.SUBKIND);
		m.put(Vocabulary.core_file_size_DP, core_file_size);
		m.put(Vocabulary.data_seg_size_DP, data_seg_size);
		m.put(Vocabulary.scheduling_priority_DP, scheduling_priority);
		m.put(Vocabulary.file_size_DP, file_size);
		m.put(Vocabulary.pending_signals_DP, pending_signals);
		m.put(Vocabulary.max_locked_memory_DP, max_locked_memory);
		m.put(Vocabulary.max_memory_size_DP, max_memory_size);
		m.put(Vocabulary.open_files_DP, open_files);
		m.put(Vocabulary.pipe_size_DP, pipe_size);
		m.put(Vocabulary.message_queues_DP, message_queues);
		m.put(Vocabulary.real_time_priority_DP, real_time_priority);
		m.put(Vocabulary.stack_size_DP, stack_size);
		m.put(Vocabulary.cpu_time_DP, cpu_time);
		m.put(Vocabulary.max_user_processes_DP, max_user_processes);
		m.put(Vocabulary.virtual_memory_DP, virtual_memory);
		m.put(Vocabulary.file_locks_DP, file_locks);
		return m;
	}
}