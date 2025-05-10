<div class="filter-container">
    <form method="post" action="<%= request.getContextPath() %>/admin/filter-job" class="form-group-h">

        <select name="company">
            <option value="">Filter by Company</option>
            <option value="CreativeMakura">CreativeMakura</option>
            <option value="NexusBytes">NexusBytes</option>
            <option value="TechSansar">TechSansar</option>
        </select>

        <select name="type">
            <option value="">Filter by Type</option>
            <option value="Full Time">Full-Time</option>
            <option value="Part Time">Part-Time</option>
            <option value="Internship">Internship</option>
        </select>

        <select name="location">
            <option value="">Filter by Location</option>
            <option value="Kathmandu">Kathmandu</option>
            <option value="Pokhara">Pokhara</option>
            <option value="Butwal">Butwal</option>
        </select>

        <select name="status">
            <option value="">Filter by Status</option>
            <option value="ACTIVE">ACCEPTED</option>
            <option value="EXPIRED">PENDING</option>
            <option value="EXPIRED">REJECTED</option>


        </select>

        <button type="submit">Apply</button>
    </form>
</div>
