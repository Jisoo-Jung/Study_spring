const fileService = (() => {
    // 파일 업로드
    const upload = async (formData) => {
        const response = await fetch("/file/upload", {
            method: "post",
            body: formData
        });
        const fileName = await response.json();
        return fileName;
    }

    return {upload: upload};
})()